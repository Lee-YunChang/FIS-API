package com.fis.repository;

import com.fis.domain.entity.ContractInformation;
import com.fis.domain.entity.SettlementDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SettlementDetailRepository extends JpaRepository<SettlementDetail,Long> {
    //List<SettlementDetail> findByCreateDtimeStartsWith(String searchMonth);

    List<SettlementDetail> findByContractInformationInAndCreateDtimeStartsWith(List<ContractInformation> contractInformations, String searchMonth);
}
