package com.techavaliation.cooperativism.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.models.AssociateModel;
import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.models.SessionModel;
import com.techavaliation.cooperativism.repositories.AssociateRepository;
import com.techavaliation.cooperativism.repositories.ScheduleRepository;
import com.techavaliation.cooperativism.repositories.SessionRepository;

@Service
public class DBService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public void instatiateDataBase() {
        ScheduleModel schedule = new ScheduleModel(null, "Pauta padrão");


        AssociateModel associate1 = new AssociateModel(null, "Draca", "draca@gmail.com", "012.345.678-90");
        AssociateModel associate2 = new AssociateModel(null, "Dorotan", "dorotan@gmail.com", "012.345.678-91");

        
        SessionModel session = new SessionModel(null, 1);
        schedule.setSession(session);
        associate1.setSession(session);
        associate2.setSession(session);
        
        session.setSchedule(schedule);
        session.setVotes(new ArrayList<>());
        session.setOpen(false);
        
        session.getAssociates().addAll(Arrays.asList(associate1, associate2));
        session.getVotes().addAll(Arrays.asList(true, false));
        
        this.scheduleRepository.save(schedule);
        this.associateRepository.saveAll(Arrays.asList(associate1, associate2));
        this.sessionRepository.save(session);
    }

}
