package com.jorgeMassaru.desafio3.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    private String zipCode;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String zipCode, String street, String complement, String neighborhood, String city, String state) {
        this.zipCode = zipCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getZipCode(), address.getZipCode()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getComplement(), address.getComplement()) && Objects.equals(getNeighborhood(), address.getNeighborhood()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getState(), address.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZipCode(), getStreet(), getComplement(), getNeighborhood(), getCity(), getState());
    }
}
