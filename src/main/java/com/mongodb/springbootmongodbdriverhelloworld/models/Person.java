package com.mongodb.springbootmongodbdriverhelloworld.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class Person {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private Integer age;
    private Date createdAt = new Date();
    private Address address;
    private List<String> hobbies;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Person setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public ObjectId getId() {
        return id;
    }

    public Person setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Person setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", address=" + address + ", hobbies=" + hobbies + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(age,
                                                                                                    person.age) && Objects.equals(
                address, person.address) && Objects.equals(hobbies, person.hobbies);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, address, hobbies);
    }

}
