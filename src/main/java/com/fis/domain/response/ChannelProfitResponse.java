package com.fis.domain.response;

import lombok.Data;

import java.util.List;

@Data
public class ChannelProfitResponse {

    private Integer profitAmt;
    private Integer creatorRsAmt;
    private List<Creator> creator;

    @Data
    public static class Creator{
        private String name;
        private Integer settlementAmt;

        public Creator(String name, Integer settlementAmt){
            this.name = name;
            this.settlementAmt = settlementAmt;
        }
    }
}
