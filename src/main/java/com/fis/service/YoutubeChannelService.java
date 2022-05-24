package com.fis.service;

import com.fis.domain.response.ChannelResponse;
import com.fis.domain.response.CreatorResponse;
import com.fis.repository.YoutubeChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class YoutubeChannelService {

    private final YoutubeChannelRepository youtubeChannelRepository;

    public List<ChannelResponse> channelList() {
        return youtubeChannelRepository.findAll().stream().map(ChannelResponse::new).collect(Collectors.toList());
    }
}
