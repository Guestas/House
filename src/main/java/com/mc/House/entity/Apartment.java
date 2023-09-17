package com.mc.House.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="vote-value")
    private Integer voteValue;
    @Column(name="branch")
    private Integer branchAntenna;
    @Column(name="flor")
    private Integer flor;
    @Column(name="addressN")
    private Integer address;
    @Column(name="street")
    private String  street;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "apartment_house_meeting",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "house_meeting_id"))
    private List<HouseMeeting> absolvedMeetings;

    public List<HouseMeeting> getAbsolvedMeetings() {
        return absolvedMeetings;
    }

    public void addHouseMeeting(HouseMeeting houseMeeting) {
        if (absolvedMeetings==null)
            absolvedMeetings = new ArrayList<>();
        absolvedMeetings.add(houseMeeting);
    }

    public Apartment() {
    }

    public Apartment(Integer voteValue, Integer branchAntena, Integer flor, Integer address, String street) {
        this.voteValue = voteValue;
        this.branchAntenna = branchAntena;
        this.flor = flor;
        this.address = address;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Integer voteValue) {
        this.voteValue = voteValue;
    }

    public Integer getBranchAntenna() {
        return branchAntenna;
    }

    public void setBranchAntenna(Integer branchAntenna) {
        this.branchAntenna = branchAntenna;
    }

    public Integer getFlor() {
        return flor;
    }

    public void setFlor(Integer flor) {
        this.flor = flor;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
