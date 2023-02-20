package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techavaliation.cooperativism.models.SessionModel;

public interface SessionRepository extends JpaRepository<SessionModel, Long>{
    
}
