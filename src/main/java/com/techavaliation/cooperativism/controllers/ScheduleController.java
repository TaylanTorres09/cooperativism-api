package com.techavaliation.cooperativism.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{id}")
    public ScheduleModel findByIdSchedule(@PathVariable Long id) {
        return this.scheduleService.findByIdSchedule(id);
    }

}
