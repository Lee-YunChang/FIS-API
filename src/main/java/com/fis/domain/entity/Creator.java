package com.fis.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "creator")
@NoArgsConstructor
@Getter
@Setter
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;

    private Date createDtime;

    @ToString.Exclude
    @OneToMany(mappedBy = "creator")
    private List<ContractInformation> contractInformations = new ArrayList<>();

}
