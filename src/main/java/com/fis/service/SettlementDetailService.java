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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SettlementDetailService {

    private final SettlementDetailRepository settlementDetailRepository;
    private final ContractInformationRepository contractInformationRepository;

    @Transactional
    public List<CreatorSettlementResponse> creatorSettlements(String month) {

        List<SettlementDetail> settlementDetails = settlementDetailRepository.findAll();

        List<CreatorSettlementResponse> responses = settlementDetails.stream()
                .collect(Collectors.groupingBy((map) ->map.getContractInformation().getId()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getKey().compareTo(a.getKey()))
                .map(entry -> {
                    ContractInformation contractInformation = contractInformationRepository.findById(entry.getKey()).orElseThrow(InvalidDataException::new);
                    int settlementAmt = entry.getValue().stream().mapToInt(s ->s.getSettlementAmount()).sum();
                    return new CreatorSettlementResponse(contractInformation.getYoutubeChannel().getChannelName(),settlementAmt);
                }).collect(Collectors.toList());

        return responses;
    }
}
