package com.techavaliation.cooperativism.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techavaliation.cooperativism.models.AssociateModel;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateModel, Long>{

    @Query("SELECT associate FROM AssociateModel associate WHERE associate.cpf = :cpf")
    AssociateModel findByCPF(@Param(value = "cpf") String cpf);
    
}
