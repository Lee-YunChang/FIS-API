package com.fis.repository;

import com.fis.domain.entity.YoutubeChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YoutubeChannelRepository extends JpaRepository<YoutubeChannel,Long> {
}
