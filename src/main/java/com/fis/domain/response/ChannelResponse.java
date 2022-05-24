package com.fis.domain.response;

import com.fis.domain.entity.YoutubeChannel;
import lombok.Data;

import java.sql.Date;

@Data
public class ChannelResponse {

    private Long id;
    private String channelName;
    private Integer CompanyRs;
    private Date createDtime;

    public ChannelResponse(YoutubeChannel channel){
        this.id = channel.getId();
        this.channelName = channel.getChannelName();
        this.CompanyRs = channel.getCompanyRs();
        this.createDtime = channel.getCreateDtime();

    }
}
