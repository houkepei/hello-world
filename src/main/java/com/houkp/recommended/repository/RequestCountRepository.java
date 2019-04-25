package com.houkp.recommended.repository;

import com.houkp.recommended.entity.RequestCountBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestCountRepository extends JpaRepository<RequestCountBean,String> {

    Page<RequestCountBean> findAll(Specification<RequestCountBean> specification, Pageable pageable);


}
