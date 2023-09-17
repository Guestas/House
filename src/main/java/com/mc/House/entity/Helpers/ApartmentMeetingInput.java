package com.mc.House.entity.Helpers;

public class ApartmentMeetingInput {
    int apartment;
    int houseMeeting;

    public ApartmentMeetingInput(int apartment, int houseMeeting) {
        this.apartment = apartment;
        this.houseMeeting = houseMeeting;
    }

    public int getApartment() {
        return apartment;
    }

    public int getHouseMeeting() {
        return houseMeeting;
    }
}
