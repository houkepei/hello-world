package com.houkp.recommended.repository;

import com.houkp.recommended.entity.BlacklistIp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistIpRepository extends JpaRepository<BlacklistIp,String> {

    Page<BlacklistIp> findAll(Specification<BlacklistIp> specification, Pageable pageable);


}
