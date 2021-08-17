package com.GiveaLot.givealot.Browse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Entity
@Table(name="recommender_table")
public class Browse
{
    @Id
    private Long userId;
    private Integer interactions;
    private String  sector;

    public Browse(){
        userId = null;
       interactions = null;
       sector = null;
    }

    public Long getOrgId() {
        return userId;
    }

    public void setOrgId(Long orgId) {
        this.userId = orgId;
    }

    public Integer getInteractions() {
        return interactions;
    }

    public void setInteractions(Integer interactions) {
        this.interactions = interactions;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}