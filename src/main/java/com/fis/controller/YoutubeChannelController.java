package com.fis.controller;

import com.fis.domain.request.ChannelProfitRequest;
import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.service.YoutubeChannelProfitService;
import com.fis.service.YoutubeChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import java.util.List;

@Tag(name = "YoutubeChannel", description = "유튜브 채널")
@RestController
@RequiredArgsConstructor
@RequestMapping("/youtubeChannel")
public class YoutubeChannelController {

    private final YoutubeChannelService youtubeChannelService;
    private final YoutubeChannelProfitService youtubeChannelProfitService;


    @Operation(summary = "채널수익금 등록")
    @PostMapping(value = "/profit", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ChannelProfitRequest value) {

        if(youtubeChannelProfitService.save(value) > 0)
            return  ResponseEntity.status(HttpStatus.CREATED).build();

        return ResponseEntity.badRequest().build();
    }

}
