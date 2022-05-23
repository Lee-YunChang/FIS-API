package com.fis.service;


import com.fis.domain.entity.YoutubeChannelProfit;
import com.fis.domain.response.CompanySalesResponse;
import com.fis.domain.response.CreatorSettlementResponse;
import com.fis.repository.YoutubeChannelProfitRepository;
import com.fis.repository.YoutubeChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final YoutubeChannelProfitRepository youtubeChannelProfitRepository;

    @Transactional
    public CompanySalesResponse companySales(String searchMonth) {

        CompanySalesResponse response = new CompanySalesResponse();

        List<YoutubeChannelProfit> youtubeChannelProfits = youtubeChannelProfitRepository.findByprofitDtimeStartsWith(searchMonth);

        int totoalSalesAmt = youtubeChannelProfits.stream().mapToInt(f -> f.getProfitAmt()).sum();
        int netSalesAmt = youtubeChannelProfits.stream().mapToInt(f -> f.getCompanyRsAmt()).sum();

        response.setTotalSalesAmt(totoalSalesAmt);
        response.setNetSalesAmt(netSalesAmt);

        return response;
    }
}
