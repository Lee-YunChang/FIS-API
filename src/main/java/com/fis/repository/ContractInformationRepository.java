package com.fis.repository;

import com.fis.domain.entity.ContractInformation;
import com.fis.domain.entity.Creator;
import com.fis.domain.entity.YoutubeChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractInformationRepository extends JpaRepository<ContractInformation ,Long> {
    List<ContractInformation> findByCreator(Creator creator);

    List<ContractInformation> findByYoutubeChannel(YoutubeChannel youtubeChannel);
}
