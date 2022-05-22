package com.fis.service;

import com.fis.repository.YoutubeChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YoutubeChannelService {

    private final YoutubeChannelRepository youtubeChannelRepository;
}
