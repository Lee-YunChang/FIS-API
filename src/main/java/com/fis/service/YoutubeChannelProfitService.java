package com.fis.service;

import com.fis.domain.entity.YoutubeChannel;
import com.fis.domain.entity.YoutubeChannelProfit;
import com.fis.domain.request.ChannelProfitRequest;
import com.fis.exception.InvalidChannelException;
import com.fis.repository.YoutubeChannelProfitRepository;
import com.fis.repository.YoutubeChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@RequiredArgsConstructor
@Service
public class YoutubeChannelProfitService {

    private final YoutubeChannelRepository youtubeChannelRepository;
    private final YoutubeChannelProfitRepository youtubeChannelProfitRepository;

    @Transactional
    public int save(ChannelProfitRequest value) {

        YoutubeChannel youtubeChannel = youtubeChannelRepository.findById(value.getChannelId()).orElseThrow(InvalidChannelException::new);

        YoutubeChannelProfit.YoutubeChannelProfitBuilder builder = YoutubeChannelProfit.builder();
        builder.youtubeChannel(youtubeChannel)
                .profitAmt(value.getProfitAmt())
                .profitDtime(Date.valueOf(value.getProfitDtime()));

        return youtubeChannelProfitRepository.save(builder.build()) != null ? 1 : 0;
    }
}
