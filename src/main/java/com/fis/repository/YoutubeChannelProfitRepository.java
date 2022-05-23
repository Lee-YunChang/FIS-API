package com.fis.repository;

import com.fis.domain.entity.YoutubeChannelProfit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YoutubeChannelProfitRepository extends JpaRepository<YoutubeChannelProfit, Long> {
    List<YoutubeChannelProfit> findByprofitDtimeStartsWith(String searchMonth);
}
