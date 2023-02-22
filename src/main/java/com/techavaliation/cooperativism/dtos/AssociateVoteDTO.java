package com.techavaliation.cooperativism.dtos;

public class AssociateVoteDTO {
    
    private Long sessionId;

    private Long associateId;

    private String vote;

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Long associateId) {
        this.associateId = associateId;
    } 

}
