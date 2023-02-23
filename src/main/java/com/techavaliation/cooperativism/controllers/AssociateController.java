package com.techavaliation.cooperativism.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techavaliation.cooperativism.dtos.AssociateDTO;
import com.techavaliation.cooperativism.dtos.AssociateVoteDTO;
import com.techavaliation.cooperativism.dtos.ResponseFindByCPFDTO;
import com.techavaliation.cooperativism.models.AssociateModel;
import com.techavaliation.cooperativism.services.AssociateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/associate")
public class AssociateController {
    
    @Autowired
    private AssociateService associateService;

    @GetMapping("/{id}")
    public AssociateModel findByIdAssociate(@PathVariable Long id) {
        return this.associateService.findByIdAssociate(id);
    }

    @PostMapping("/create")
    public ResponseEntity<AssociateModel> create(@Valid @RequestBody AssociateDTO associateDTO) {
        AssociateModel associate = this.associateService.create(associateDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(String.format("/associate/%d", associate.getId())).buildAndExpand(associate.getId()).toUri();
        
        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/vote")
    public String voteAssociateInSessionSchedule(@RequestBody AssociateVoteDTO associateVoteDTO) {
        return this.associateService.voteAssociateInSessionSchedule(associateVoteDTO.getSessionId(), associateVoteDTO.getAssociateId(), associateVoteDTO.getVote());
    }

    @GetMapping()
    public ResponseFindByCPFDTO findByCPF(@RequestParam(name = "cpf") String cpf) {
        return this.associateService.findByCPF(cpf);
    }

}
