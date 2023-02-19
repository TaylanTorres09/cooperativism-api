package com.techavaliation.cooperativism.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessions")
public class SessionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "schedule_id")
    private ScheduleModel schedule;

    private LocalDateTime timer;
    
    private List<Boolean> votes = new ArrayList<>();

    private List<AssociateModel> associates = new ArrayList<>();

    public SessionModel(Long id, ScheduleModel schedule) {
        this.id = id;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScheduleModel getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleModel schedule) {
        this.schedule = schedule;
    }

    public LocalDateTime getTimer() {
        return timer;
    }

    public void setTimer(LocalDateTime timer) {
        this.timer = timer;
    }

    public List<Boolean> getVotes() {
        return votes;
    }

    public void setVotes(List<Boolean> votes) {
        this.votes = votes;
    }

    public List<AssociateModel> getAssociates() {
        return associates;
    }

    public void setAssociates(List<AssociateModel> associates) {
        this.associates = associates;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SessionModel other = (SessionModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}