package com.fis.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "youtue_channel_profit")
@Getter
@Setter
@NoArgsConstructor
public class YoutubeChannelProfit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @JoinColumn(name = "youtube_channel_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YoutubeChannel youtubeChannel;

    private Integer profitAmt;

    private Date profitDtime;

    @Builder
    public YoutubeChannelProfit(YoutubeChannel youtubeChannel, Integer profitAmt, Date profitDtime){
        this.youtubeChannel = youtubeChannel;
        this.profitAmt = profitAmt;
        this.profitDtime = profitDtime;
    }
}
