package com.GiveaLot.givealot.Browse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Table(name="recommender_table")
public class Browse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rec_id", nullable = false, unique = true)
    public Long rec_id;

    private Long userId;
    private Integer interactions;
    private String  sector;

    public Browse(){
       userId = null;
       interactions = null;
       sector = null;
       rec_id = null;
    }

    public Long getRec_id() {
        return rec_id;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long orgId) {
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