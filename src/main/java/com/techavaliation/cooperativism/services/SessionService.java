package com.techavaliation.cooperativism.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.dtos.SessionDTO;
import com.techavaliation.cooperativism.models.ScheduleModel;
import com.techavaliation.cooperativism.models.SessionModel;
import com.techavaliation.cooperativism.repositories.SessionRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class SessionService {
    
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ScheduleService scheduleService;

    public SessionModel findByIdSessionModel(Long id) {
        return this.sessionRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Session id: "+ id + " não existe"));
    }

    public SessionModel openSession(SessionDTO sessionDTO) {
        SessionModel session = new SessionModel();
        ScheduleModel schedule = this.scheduleService.findByIdSchedule(sessionDTO.getScheduleId());
        session.setTimer(new Date());
        session.setSchedule(schedule);
        return this.sessionRepository.save(session);
    }


}
