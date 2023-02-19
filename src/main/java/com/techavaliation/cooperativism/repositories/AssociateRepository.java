package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techavaliation.cooperativism.models.AssociateModel;

public interface AssociateRepository extends JpaRepository<AssociateModel, Long>{
    
}
