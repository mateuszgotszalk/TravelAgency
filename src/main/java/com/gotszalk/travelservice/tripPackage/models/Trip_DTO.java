package com.gotszalk.travelservice.tripPackage.models;

import java.math.BigDecimal;


public class Trip_DTO {

    private Long tripId;
    private BigDecimal totalCost;
    private String salesman;
    private Status status;

    public Trip_DTO() {
    }

    public Trip_DTO(Long tripId, BigDecimal totalCost, String salesman, Status status) {
        this.tripId = tripId;
        this.totalCost = totalCost;
        this.salesman = salesman;
        this.status = status;
    }



    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Trip_DTO(final Builder builder) {
        this.tripId = builder.tripId;
        this.totalCost = builder.totalCost;
        this.salesman = builder.salesman;
        this.status = builder.status;
    }

    public static class Builder{

        private Long tripId;
        private BigDecimal totalCost;
        private String salesman;
        private Status status;


        public Builder() {
        }

        public Builder tripId(Long tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder totalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder salesman(String salesman) {
            this.salesman = salesman;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Trip_DTO build(){
            return new Trip_DTO(this);
        }
    }
}
