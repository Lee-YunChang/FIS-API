package com.fis.service;

import com.fis.domain.entity.ContractInformation;
import com.fis.domain.entity.Creator;
import com.fis.domain.entity.SettlementDetail;
import com.fis.domain.entity.YoutubeChannel;
import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.exception.InvalidDataException;
import com.fis.exception.InvalidUserException;
import com.fis.repository.ContractInformationRepository;
import com.fis.repository.CreatorRepository;
import com.fis.repository.SettlementDetailRepository;
import com.fis.repository.YoutubeChannelRepository;
import com.fis.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SettlementDetailService {

    private final SettlementDetailRepository settlementDetailRepository;
    private final ContractInformationRepository contractInformationRepository;
    private final CreatorRepository creatorRepository;
    @Transactional
    public List<CreatorSettlementResponse> creatorSettlements(long id, String searchMonth) {

        Date startDate =  Date.valueOf(searchMonth+"-01");
        Date endDate = Date.valueOf(searchMonth+ "-"+ DateUtils.MaximumOfMonth(searchMonth));

        Creator creator = creatorRepository.findById(id).orElseThrow(InvalidUserException::new);
        List<ContractInformation> contractInformations = contractInformationRepository.findByCreator(creator);
        List<SettlementDetail> settlementDetails = settlementDetailRepository.findByContractInformationInAndCreateDtimeBetween(contractInformations,startDate,endDate);

        List<CreatorSettlementResponse> responses = settlementDetails.stream()
                .collect(Collectors.groupingBy((map) ->map.getContractInformation().getId()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .map(entry -> {
                    ContractInformation contractInformation = contractInformationRepository.findById(entry.getKey()).orElseThrow(InvalidDataException::new);
                    int settlementAmt = entry.getValue().stream().mapToInt(s ->s.getSettlementAmt()).sum();
                    return new CreatorSettlementResponse(contractInformation.getYoutubeChannel().getChannelName(),settlementAmt);
                }).collect(Collectors.toList());

        return responses;
    }
}
