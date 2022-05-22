package com.fis.repository;

import com.fis.domain.entity.ContractInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractInformationRepository extends JpaRepository<ContractInformation ,Long> {
}
