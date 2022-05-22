package com.fis.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "contract_information")
@NoArgsConstructor
@Getter
@Setter
public class ContractInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @JoinColumn(name = "youtube_channel_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private YoutubeChannel youtubeChannel;


    @JoinColumn(name = "creator_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Creator creator;

    private Integer rate;

    private Date createDtime;

    @Builder
    public ContractInformation(YoutubeChannel youtubeChannel, Creator creator, Integer rate, Date createDtime){
        this.youtubeChannel = youtubeChannel;
        this.creator = creator;
        this.rate = rate;
        this.createDtime = createDtime;
    }
}
