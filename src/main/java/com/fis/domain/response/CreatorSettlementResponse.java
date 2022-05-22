package com.fis.domain.response;

import lombok.Data;

@Data
public class CreatorSettlementResponse {

    private String name;
    private Integer settlementAmt;


    public CreatorSettlementResponse(String name, Integer settlementAmt){
        this.name = name;
        this.settlementAmt = settlementAmt;
    }
}
