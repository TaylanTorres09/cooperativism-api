package com.techavaliation.cooperativism.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.techavaliation.cooperativism.dtos.SessionDTO;
import com.techavaliation.cooperativism.models.SessionModel;
import com.techavaliation.cooperativism.services.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {
    
    @Autowired
    private SessionService sessionService;

    @GetMapping("/{id}")
    public SessionModel findBySessionModel(@PathVariable Long id) {
        return this.sessionService.findByIdSessionModel(id);
    }

    @PostMapping("/open-close-session")
    public ResponseEntity<SessionModel> openSession(@RequestBody SessionDTO sessionDTO) {
        SessionModel session = this.sessionService.openSession(sessionDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(String.format("/session/%d", session.getId())).buildAndExpand(session.getId()).toUri();
        
        this.sessionService.closeSession(session.getMinutes(), session.getId());

        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/count-votes/{sessionId}")
    public String countVotes(@PathVariable Long sessionId) {
        return this.sessionService.countVotes(sessionId);
    }

}
