package com.houkp.recommended.repository;

import com.houkp.recommended.entity.BidCountBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidCountRepository extends JpaRepository<BidCountBean,String> {

    Page<BidCountBean> findAll(Specification<BidCountBean> specification, Pageable pageable);


}
