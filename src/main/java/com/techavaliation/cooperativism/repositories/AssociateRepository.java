package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techavaliation.cooperativism.models.AssociateModel;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateModel, Long>{
    
}
