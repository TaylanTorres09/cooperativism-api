package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techavaliation.cooperativism.models.ScheduleModel;

public interface ScheduleRepository extends JpaRepository<ScheduleModel, Long> {
    
}
