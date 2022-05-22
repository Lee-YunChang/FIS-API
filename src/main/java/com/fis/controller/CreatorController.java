package com.fis.controller;

import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.service.SettlementDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Creator", description = "크리에이터")
@RestController
@RequiredArgsConstructor
@RequestMapping("/creator")
public class CreatorController {

    private SettlementDetailService settlementDetailService;


    @Operation(summary = "사용자 계좌별 예치금")
    @GetMapping(value = "/settlement")
    public ResponseEntity<List<CreatorSettlementResponse>> creatorSettlements(@RequestParam(value = "month") String  month) {
        return ResponseEntity.ok().body(settlementDetailService.creatorSettlements(month));
    }
}
