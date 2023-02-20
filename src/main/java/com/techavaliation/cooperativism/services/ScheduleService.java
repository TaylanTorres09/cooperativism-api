package com.techavaliation.cooperativism.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.repositories.ScheduleRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleModel findByIdSchedule(Long id) {
        return this.scheduleRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Pauta: " + id + ", não encontrada."));
    }

}
