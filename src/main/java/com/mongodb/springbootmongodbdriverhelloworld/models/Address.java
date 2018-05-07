package com.mongodb.springbootmongodbdriverhelloworld.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class Address {

    private Integer number;
    private String street;
    private String postCode;
    private String town;

    public Integer getNumber() {

        return number;
    }

    public Address setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getTown() {
        return town;
    }

    public Address setTown(String town) {
        this.town = town;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" + "number=" + number + ", street='" + street + '\'' + ", postCode='" + postCode + '\'' + ", town='" + town + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address address = (Address) o;
        return Objects.equals(number, address.number) && Objects.equals(street, address.street) && Objects.equals(postCode,
                                                                                                                  address.postCode) && Objects
                .equals(town, address.town);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, street, postCode, town);
    }
}
