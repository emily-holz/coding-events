package org.launchcode.codingevents.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message="Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @NotBlank(message="Location must be provided.")
    private String location;

    private boolean needToRegister;

    @Min(value = 1, message = "Participant size must be 1 or more.")
    private int numberOfAttendees;

    @ManyToOne
    @NotNull(message="Category is required.")
    private EventCategory eventCategory;


    public Event(){}

    public Event(String name, String location, boolean needToRegister, int numberOfAttendees, EventCategory eventCategory) {
        this.name = name;
        this.location = location;
        this.needToRegister = needToRegister;
        this.numberOfAttendees = numberOfAttendees;
        this.eventCategory= eventCategory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isNeedToRegister() {
        return needToRegister;
    }

    public void setNeedToRegister(boolean needToRegister) {
        this.needToRegister = needToRegister;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return name;
    }


}
