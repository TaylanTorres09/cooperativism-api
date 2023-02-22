package com.techavaliation.cooperativism.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.dtos.AssociateDTO;
import com.techavaliation.cooperativism.models.AssociateModel;
import com.techavaliation.cooperativism.models.SessionModel;
import com.techavaliation.cooperativism.repositories.AssociateRepository;
import com.techavaliation.cooperativism.services.exceptions.ObjectNotFound;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SessionService sessionService;

    public AssociateModel findByIdAssociate(Long id) {
        return this.associateRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFound("Associado id: " + id + " não existe"));
    }

    public AssociateModel create(AssociateDTO associateDTO) {
        return this.associateRepository.save(mapper.map(associateDTO, AssociateModel.class));
    }

    public String voteAssociateInSessionSchedule(Long sessionId, Long associateId, String vote ) {
        SessionModel session = this.sessionService.findByIdSessionModel(sessionId);
        if(session.getOpen() && this.associateVote(session, associateId)) {
            AssociateModel associate = this.findByIdAssociate(associateId);
            
            associate.setSession(session);
            this.associateRepository.save(associate);

            session.getVotes().add(vote.equals("Sim") ? true : false);

            this.sessionService.saveSession(session);

            return "Sucesso";
        } else if (session.getOpen()) {
            return "Você já votou";
        }
        return "Sessão encerrada";
    }

    public Boolean associateVote(SessionModel session, Long associateId) {
        List<AssociateModel> associate = session.getAssociates().stream().filter(ass -> ass.getId() == associateId).toList();
        if(associate.isEmpty()) {
            return true;
        }
        return false;
    }

}
