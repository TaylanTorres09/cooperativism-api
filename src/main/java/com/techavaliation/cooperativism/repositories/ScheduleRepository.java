package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techavaliation.cooperativism.models.ScheduleModel;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {
    
}
