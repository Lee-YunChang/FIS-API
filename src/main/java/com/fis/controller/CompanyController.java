package com.fis.controller;

import com.fis.domain.response.CompanySalesResponse;
import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.service.CompanyService;
import com.fis.service.YoutubeChannelProfitService;
import com.fis.service.YoutubeChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Company", description = "회사 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Operation(summary = "월별회사 매출")
    @GetMapping(value = "/sales")
    public ResponseEntity<CompanySalesResponse> companySales(@RequestParam(value = "searchMonth") @DateTimeFormat(pattern = "yyyy-MM")String  searchMonth) {
        return ResponseEntity.ok().body(companyService.companySales(searchMonth));
    }
}
