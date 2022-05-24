package com.fis.domain.response;

import com.fis.domain.entity.Creator;
import lombok.Data;

import java.sql.Date;

@Data
public class CreatorResponse {

    private Long id;
    private String name;
    private Date createDtime;

    public CreatorResponse(Creator creator){
        this.id = creator.getId();
        this.name = creator.getName();
        this.createDtime = creator.getCreateDtime();
    }
}
