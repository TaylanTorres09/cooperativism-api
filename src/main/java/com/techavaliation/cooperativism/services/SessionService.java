package com.techavaliation.cooperativism.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.models.SessionModel;
import com.techavaliation.cooperativism.repositories.SessionRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class SessionService {
    
    @Autowired
    private SessionRepository sessionRepository;

    public SessionModel findByIdSessionModel(Long id) {
        return this.sessionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Session id: "+ id + " não existe"));
    }

}
