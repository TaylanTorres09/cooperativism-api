package com.techavaliation.cooperativism.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
