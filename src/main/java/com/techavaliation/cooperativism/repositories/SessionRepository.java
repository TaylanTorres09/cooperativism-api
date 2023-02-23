package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techavaliation.cooperativism.models.SessionModel;

@Repository
public interface SessionRepository extends JpaRepository<SessionModel, Long>{

}
