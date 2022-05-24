package com.fis.controller;

import com.fis.domain.request.ChannelProfitRequest;
import com.fis.domain.response.ChannelProfitResponse;
import com.fis.domain.response.ChannelResponse;
import com.fis.domain.response.CreatorResponse;
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



    @Operation(summary = "유튜브 채널 리스트")
    @GetMapping(value = "")
    public ResponseEntity<List<ChannelResponse>> channelList() {
        return ResponseEntity.ok().body(youtubeChannelService.channelList());
    }

    @Operation(summary = "채널수익금 등록")
    @PostMapping(value = "/profit", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ChannelProfitRequest value) {

        if(youtubeChannelProfitService.save(value) > 0)
            return  ResponseEntity.status(HttpStatus.CREATED).build();

        return ResponseEntity.badRequest().build();
    }


    @Operation(summary = "채널 수익금 및 크리에이터 정산금액 조회")
    @GetMapping(value = "/profit/{id}")
    public ResponseEntity<ChannelProfitResponse> channelProfit(@PathVariable("id") long id, @RequestParam(value = "searchMonth") @DateTimeFormat(pattern = "yyyy-MM")String  searchMonth) {
        return ResponseEntity.ok().body(youtubeChannelProfitService.channelProfit(id,searchMonth));
    }
}
