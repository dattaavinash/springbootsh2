package com.example.spdbconc.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spdbconc.domain.entities.LeaveEntity;

public interface LeaveRepository extends JpaRepository<LeaveEntity,Long>{

}
