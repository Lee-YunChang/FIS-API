package com.fis.service;

import com.fis.domain.entity.ContractInformation;
import com.fis.domain.entity.Creator;
import com.fis.domain.entity.YoutubeChannel;
import com.fis.domain.request.ChannelProfitRequest;
import com.fis.domain.request.ContractInformationRequest;
import com.fis.exception.InvalidChannelException;
import com.fis.exception.InvalidUserException;
import com.fis.repository.ContractInformationRepository;
import com.fis.repository.CreatorRepository;
import com.fis.repository.YoutubeChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@RequiredArgsConstructor
@Service
public class ContractInformationService {

    private final ContractInformationRepository contractInformationRepository;
    private final YoutubeChannelRepository youtubeChannelRepository;
    private final CreatorRepository creatorRepository;

    @Transactional
    public int save(ContractInformationRequest value) {

        YoutubeChannel youtubeChannel = youtubeChannelRepository.findById(value.getChannelId()).orElseThrow(InvalidChannelException::new);
        Creator creator = creatorRepository.findById(value.getCreatorId()).orElseThrow(InvalidUserException::new);

        ContractInformation.ContractInformationBuilder builder = ContractInformation.builder();
        builder.youtubeChannel(youtubeChannel)
                .creator(creator)
                .rate(value.getRate())
                .createDtime(Date.valueOf(value.getCreateDtime()));

        return contractInformationRepository.save(builder.build()) != null ? 1 : 0;
    }
}
