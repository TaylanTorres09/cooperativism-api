package com.techavaliation.cooperativism.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.dtos.AssociateDTO;
import com.techavaliation.cooperativism.models.AssociateModel;
import com.techavaliation.cooperativism.repositories.AssociateRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class AssociateService {
    
    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private ModelMapper mapper;

    public AssociateModel findByIdAssociate(Long id) {
        return this.associateRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Associado id: " + id + " não existe"));
    }

    public AssociateModel create(AssociateDTO associateDTO) {
        return this.associateRepository.save(mapper.map(associateDTO, AssociateModel.class));
    }

}
