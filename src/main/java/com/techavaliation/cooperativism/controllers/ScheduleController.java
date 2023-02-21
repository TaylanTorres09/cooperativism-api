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

import com.techavaliation.cooperativism.dtos.ScheduleDTO;
import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.services.ScheduleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{id}")
    public ScheduleModel findByIdSchedule(@PathVariable Long id) {
        return this.scheduleService.findByIdSchedule(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ScheduleModel> createSchedule(@Valid @RequestBody ScheduleDTO scheduleDTO) {
        ScheduleModel schedule = this.scheduleService.createSchedule(scheduleDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path(String.format("/schedule/%d", schedule.getId())).buildAndExpand(schedule.getId()).toUri();
        
        //return uri in headers
        return ResponseEntity.created(uri).build();
    }

}
