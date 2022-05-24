package com.fis.service;

import com.fis.domain.response.CreatorResponse;
import com.fis.repository.CreatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreatorService {

    private final CreatorRepository creatorRepository;

    public List<CreatorResponse> creatorList() {
        return creatorRepository.findAll().stream().map(CreatorResponse::new).collect(Collectors.toList());
    }
}
