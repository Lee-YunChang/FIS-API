package com.fis.repository;

import com.fis.domain.entity.YoutubeChannel;
import com.fis.domain.entity.YoutubeChannelProfit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface YoutubeChannelProfitRepository extends JpaRepository<YoutubeChannelProfit, Long> {
    List<YoutubeChannelProfit> findByProfitDtimeStartsWith(Date searchMonth);

    List<YoutubeChannelProfit> findByYoutubeChannelAndProfitDtimeStartsWith(YoutubeChannel youtubeChannel, Date searchMonth);
}
