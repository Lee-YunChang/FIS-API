package com.fis.controller;

import com.fis.domain.request.ChannelProfitRequest;
import com.fis.domain.request.ContractInformationRequest;
import com.fis.service.ContractInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "ContractInformation", description = "계약정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("/contractInformation")
public class ContractInformationController {

    private final ContractInformationService contractInformationService;

    @Operation(summary = "계약정보 등록")
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ContractInformationRequest value) {

        if(contractInformationService.save(value) > 0)
            return  ResponseEntity.status(HttpStatus.CREATED).build();

        return ResponseEntity.badRequest().build();
    }
}
