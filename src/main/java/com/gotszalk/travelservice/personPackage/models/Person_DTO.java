package com.gotszalk.travelservice.personPackage.models;

import com.gotszalk.travelservice.tripPackage.models.Trip_DTO;

import java.util.List;

public class Person_DTO {

    private String name;
    private String surrName;
    private String dateOfBirth;
    private Role role;
    private List<Trip_DTO> trips_DTO;

    public Person_DTO() {
    }

    public Person_DTO(String name, String surrName, String dateOfBirth, Role role,
                      List<Trip_DTO> trips_DTO) {
        this.name = name;
        this.surrName = surrName;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.trips_DTO = trips_DTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrName() {
        return surrName;
    }

    public void setSurrName(String surrName) {
        this.surrName = surrName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Trip_DTO> getTrips_DTO() {
        return trips_DTO;
    }

    public void setTrips_DTO(List<Trip_DTO> trips_DTO) {
        this.trips_DTO = trips_DTO;
    }

    private Person_DTO(final Builder builder){
        this.name = builder.name;
        this.dateOfBirth = builder.dateOfBirth;
        this.role = builder.role;
        this.surrName = builder.surrName;
        this.trips_DTO = builder.trips_DTO;
    }

    public static class Builder{

        private String name;
        private String surrName;
        private String dateOfBirth;
        private Role role;
        private List<Trip_DTO> trips_DTO;


        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surrName(String surrName) {
            this.surrName = surrName;
            return this;
        }

        public Builder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }
        public Builder trips_DTO(List<Trip_DTO> trips_DTO) {
            this.trips_DTO = trips_DTO;
            return this;
        }

        public Person_DTO build(){
            return new Person_DTO(this);
        }
    }
}
