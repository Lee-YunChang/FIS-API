package com.fis.controller;

import com.fis.domain.response.CreatorResponse;
import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.service.CreatorService;
import com.fis.service.SettlementDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Past;
import java.util.List;

@Tag(name = "Creator", description = "크리에이터")
@RestController
@RequiredArgsConstructor
@RequestMapping("/creator")
public class CreatorController {

    private final CreatorService creatorService;
    private final SettlementDetailService settlementDetailService;


    @Operation(summary = "크리에이터 리스트")
    @GetMapping(value = "")
    public ResponseEntity<List<CreatorResponse>> creatorList() {
        return ResponseEntity.ok().body(creatorService.creatorList());
    }

    @Operation(summary = "크리에이터 별 정산금액")
    @GetMapping(value = "/settlement/{id}")
    public ResponseEntity<List<CreatorSettlementResponse>> creatorSettlements(@PathVariable("id") long id,@RequestParam(value = "searchMonth") @DateTimeFormat(pattern = "yyyy-MM")String  searchMonth) {
        return ResponseEntity.ok().body(settlementDetailService.creatorSettlements(id,searchMonth));
    }
}
