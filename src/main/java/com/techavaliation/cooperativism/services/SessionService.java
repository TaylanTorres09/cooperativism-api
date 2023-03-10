package com.techavaliation.cooperativism.services;

import java.util.ArrayList;
import java.util.List;
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
        schedule.setSession(session);
        session.setOpen(true);
        session.setMinutes((sessionDTO.getMinutes() != null) ? sessionDTO.getMinutes() : 1);
        session.setSchedule(schedule);
        session.setVotes(new ArrayList<>());
        return this.saveSession(session);
    }

    public void closeSession(Integer minutes, Long id) {
        SessionModel session = this.findByIdSessionModel(id);
        this.saveSession(session);
    }

    public SessionModel saveSession(SessionModel session) {
        return this.sessionRepository.save(session);
    }

    public String countVotes(Long id) {
        SessionModel session = this.findByIdSessionModel(id);

        List<Boolean> votes = session.getVotes();
        Integer votesTrue = 0;
        for(Boolean vote: votes) {
            votesTrue += vote ? 1 : 0;
        }
        Integer votesFalse = votes.size() - votesTrue;

        return String.format("Votos sim: %d, votos não: %d", votesTrue, votesFalse);

    }

}
