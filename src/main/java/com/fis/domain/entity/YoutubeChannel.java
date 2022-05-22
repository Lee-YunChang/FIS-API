package com.fis.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "youtue_channel")
@Getter
@Setter
@NoArgsConstructor
public class YoutubeChannel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToMany(mappedBy = "youtubeChannel")
    private List<YoutubeChannelProfit> youtubeChannelProfits = new ArrayList<>();

    private String channelName;

    private Date createDtime;

}
