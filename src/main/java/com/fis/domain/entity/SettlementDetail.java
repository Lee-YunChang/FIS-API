package com.fis.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "settlement_detail")
@NoArgsConstructor
@Getter
@Setter
public class SettlementDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;


    @JoinColumn(name = "youtube_channel_profit_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YoutubeChannelProfit youtubeChannelProfit;

    @JoinColumn(name = "contract_information")
    @ManyToOne(fetch = FetchType.LAZY)
    private ContractInformation contractInformation;

    private Integer settlementAmount;

    private Date createDtime;

    @Builder
    public SettlementDetail(YoutubeChannelProfit youtubeChannelProfit, ContractInformation contractInformation, Integer settlementAmount, Date createDtime){
        this.youtubeChannelProfit = youtubeChannelProfit;
        this.contractInformation = contractInformation;
        this.settlementAmount = settlementAmount;
        this.createDtime = createDtime;
    }
}
