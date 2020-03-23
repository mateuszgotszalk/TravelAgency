package com.gotszalk.travelservice.personPackage.models;

public class PersonInput {

    private String name;
    private String surrName;
    private String dateOfBirth;
    private Role role;

    public PersonInput() {
    }

    public PersonInput(String name, String surrName, String dateOfBirth, Role role) {
        this.name = name;
        this.surrName = surrName;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
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

    @Override
    public String toString() {
        return "PersonInput{" +
                "name='" + name + '\'' +
                ", surrName='" + surrName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", role=" + role +
                '}';
    }
}
