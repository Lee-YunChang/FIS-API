package com.fis.repository;

import com.fis.domain.entity.ContractInformation;
import com.fis.domain.entity.SettlementDetail;
import com.fis.domain.entity.YoutubeChannelProfit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SettlementDetailRepository extends JpaRepository<SettlementDetail,Long> {

    List<SettlementDetail> findByYoutubeChannelProfitIn(List<YoutubeChannelProfit> youtubeChannelProfits);

    List<SettlementDetail> findByContractInformationInAndCreateDtimeBetween(List<ContractInformation> contractInformations, Date startDate, Date endDate);
}
