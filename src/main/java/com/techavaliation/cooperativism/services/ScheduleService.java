package com.techavaliation.cooperativism.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.dtos.ScheduleDTO;
import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.repositories.ScheduleRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ModelMapper mapper;

    public ScheduleModel findByIdSchedule(Long id) {
        return this.scheduleRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Pauta: " + id + ", não encontrada."));
    }

    public ScheduleModel createSchedule(ScheduleDTO scheduleDTO) {
        return this.scheduleRepository.save(mapper.map(scheduleDTO, ScheduleModel.class));
    }

}
