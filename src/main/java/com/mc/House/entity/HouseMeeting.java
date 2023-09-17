package com.mc.House.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Meetings")
public class HouseMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="date")
    private String date;
    @Column(name="name")
    private String name;
    @Column(name="topics")
    private List<String> topics;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "apartment_house_meeting",
            joinColumns = @JoinColumn(name = "house_meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    private List<Apartment> apartments;

    public void addApartment(Apartment apartment) {
        if (apartments==null)
            apartments = new ArrayList<>();
        apartments.add(apartment);
    }

    public HouseMeeting() {
    }

    public HouseMeeting(String date, String name, List<String> topics) {
        this.date = date;
        this.name = name;
        this.topics = topics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    private String getTopicsString(List<String> topics){
        StringBuilder out = new StringBuilder();
        for (String s: topics) {
            out.append("\"").append(s).append("\", ");
        }
        return (out.isEmpty()) ?"Nothing": out.toString();
    }

    @Override
    public String toString() {
        return "HouseMeeting{" +
                "id=" + id +
                ", date=\"" + date + "\"" +
                ", name=\"" + name + "\"" +
                ", topics=[" + getTopicsString(topics) +
                "]}";
    }
}
