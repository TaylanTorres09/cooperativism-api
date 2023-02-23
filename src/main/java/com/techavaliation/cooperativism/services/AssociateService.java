package com.techavaliation.cooperativism.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techavaliation.cooperativism.dtos.AssociateDTO;
import com.techavaliation.cooperativism.dtos.ResponseFindByCPFDTO;
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
            
            session.getVotes().add(vote.equals("Sim") ? true : false);
            session.getAssociates().add(associate);
            
            this.associateRepository.save(associate);
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

    public ResponseFindByCPFDTO findByCPF(String cpf) {
        try {
            
            AssociateModel associate = this.associateRepository.findByCPF(cpf);
            this.findByIdAssociate(associate.getId());
            
            ResponseFindByCPFDTO response = new ResponseFindByCPFDTO();
            if (associate.getSession() == null) {
                response.setStatus("ABLE_TO_VOTE");
                return response;
            } else if (associate.getSession().getOpen() && this.associateVote(associate.getSession(), associate.getId())) {
                response.setStatus("ABLE_TO_VOTE");
                return response;
            } else if(!associate.getSession().getOpen()) {
                response.setStatus("ABLE_TO_VOTE");
                return response;
            }

            response.setStatus("UNABLE_TO_VOTE");
            return response;
        } catch (NullPointerException e) {
            throw new com.techavaliation.cooperativism.services.exceptions.NullPointerException("Not Found");
        }
    }

}
