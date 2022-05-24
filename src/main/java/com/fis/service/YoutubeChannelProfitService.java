package com.fis.service;

import com.fis.domain.entity.*;
import com.fis.domain.request.ChannelProfitRequest;
import com.fis.domain.response.ChannelProfitResponse;
import com.fis.exception.InvalidChannelException;
import com.fis.exception.InvalidUserException;
import com.fis.repository.*;
import com.fis.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class YoutubeChannelProfitService {

    private final YoutubeChannelRepository youtubeChannelRepository;
    private final YoutubeChannelProfitRepository youtubeChannelProfitRepository;
    private final SettlementDetailRepository settlementDetailRepository;
    private final CreatorRepository creatorRepository;
    private final ContractInformationRepository contractInformationRepository;

    @Transactional
    public int save(ChannelProfitRequest value) {

        YoutubeChannel youtubeChannel = youtubeChannelRepository.findById(value.getChannelId()).orElseThrow(InvalidChannelException::new);
        List<ContractInformation> contractInformations = contractInformationRepository.findByYoutubeChannel(youtubeChannel);

        YoutubeChannelProfit.YoutubeChannelProfitBuilder builder = YoutubeChannelProfit.builder();
        builder.youtubeChannel(youtubeChannel)
                .profitAmt(value.getProfitAmt())
                .companyRsAmt((int) (value.getProfitAmt() * (youtubeChannel.getCompanyRs()*0.01)))
                .creatorRsAmt((int) (value.getProfitAmt() * ((100 - youtubeChannel.getCompanyRs())*0.01)))
                .profitDtime(Date.valueOf(value.getProfitDtime()));

        YoutubeChannelProfit youtubeChannelProfit = youtubeChannelProfitRepository.save(builder.build());

        for(ContractInformation contractInformation : contractInformations){

            SettlementDetail.SettlementDetailBuilder settlementDetailBuilder = SettlementDetail.builder();
            settlementDetailBuilder.youtubeChannelProfit(youtubeChannelProfit)
                    .contractInformation(contractInformation)
                    .settlementAmt((contractInformation.getRate()/100)*youtubeChannelProfit.getCreatorRsAmt())
                    .createDtime(Date.valueOf(value.getProfitDtime()));

            settlementDetailRepository.save(settlementDetailBuilder.build());
        }
        return youtubeChannelProfit != null ? 1 : 0;
    }

    @Transactional
    public ChannelProfitResponse channelProfit(long id, String searchMonth) {

        ChannelProfitResponse response = new ChannelProfitResponse();

        Date startDate =  Date.valueOf(searchMonth+"-01");
        Date endDate = Date.valueOf(searchMonth+ "-"+DateUtils.MaximumOfMonth(searchMonth));

        YoutubeChannel youtubeChannel = youtubeChannelRepository.findById(id).orElseThrow(InvalidChannelException::new);
        List<YoutubeChannelProfit> youtubeChannelProfits = youtubeChannelProfitRepository.findByYoutubeChannelAndProfitDtimeBetween(youtubeChannel,startDate,endDate);
        List<SettlementDetail> settlementDetails = settlementDetailRepository.findByYoutubeChannelProfitIn(youtubeChannelProfits);

        List<ChannelProfitResponse.Creator> creators = settlementDetails.stream()
                .collect(Collectors.groupingBy((map) ->map.getContractInformation().getCreator().getId()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .map(entry -> {
                    Creator creator = creatorRepository.findById(entry.getKey()).orElseThrow(InvalidUserException::new);
                    int settlementAmt = entry.getValue().stream().mapToInt(s ->s.getSettlementAmt()).sum();
                    return new ChannelProfitResponse.Creator(creator.getName(),settlementAmt);
                }).collect(Collectors.toList());

        int profitAmt = youtubeChannelProfits.stream().mapToInt(s -> s.getProfitAmt()).sum(); // 해당 채널 전체 수익금
        int creatorRsAmt = youtubeChannelProfits.stream().mapToInt(s -> s.getCreatorRsAmt()).sum(); //크리에이터 수익금 배분

        response.setProfitAmt(profitAmt);
        response.setCreatorRsAmt(creatorRsAmt);
        response.setCreator(creators);

        return response;
    }
}
