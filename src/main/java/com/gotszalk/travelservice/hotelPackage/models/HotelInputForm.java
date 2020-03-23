package com.gotszalk.travelservice.hotelPackage.models;

public class HotelInputForm {

    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

    public HotelInputForm() {
    }

    public HotelInputForm(String hotelName, String hotelCountry, String hotelCity) {
        this.hotelName = hotelName;
        this.hotelCountry = hotelCountry;
        this.hotelCity = hotelCity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    private HotelInputForm(final Builder builder){
        this.hotelName = builder.hotelName;
        this.hotelCountry = builder.hotelCountry;
        this.hotelCity = builder.hotelCity;
    }

    public static class Builder{
        private String hotelName;
        private String hotelCountry;
        private String hotelCity;

        public Builder() {
        }

        public Builder hotelName(String hotelName){
            this.hotelName = hotelName;
            return this;
        }

        public Builder hotelCountry(String hotelCountry){
            this.hotelCountry = hotelCountry;
            return this;
        }

        public Builder hotelCity(String hotelCity){
            this.hotelCity = hotelCity;
            return this;
        }

        public HotelInputForm build(){
            return new HotelInputForm(this);
        }
    }
}
