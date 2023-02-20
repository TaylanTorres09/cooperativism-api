package com.techavaliation.cooperativism.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techavaliation.cooperativism.models.AssociateModel;
import com.techavaliation.cooperativism.services.AssociateService;

@RestController
@RequestMapping("/associate")
public class AssociateController {
    
    @Autowired
    private AssociateService associateService;

    @GetMapping("/{id}")
    public AssociateModel findByIdAssociate(@PathVariable Long id) {
        return this.associateService.findByIdAssociate(id);
    }

}
