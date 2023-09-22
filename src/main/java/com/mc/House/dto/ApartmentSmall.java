package com.mc.House.dto;

import jakarta.persistence.Column;
//TODO finish shorter versions to print all
public class ApartmentSmall {
    private Integer id;

    private Integer voteValue;

    private Integer branchAntenna;

    private Integer flor;

    private Integer address;

    private String  street;

    public ApartmentSmall() {
    }

    public ApartmentSmall(Integer id, Integer voteValue, Integer branchAntenna, Integer flor, Integer address, String street) {
        this.id = id;
        this.voteValue = voteValue;
        this.branchAntenna = branchAntenna;
        this.flor = flor;
        this.address = address;
        this.street = street;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
