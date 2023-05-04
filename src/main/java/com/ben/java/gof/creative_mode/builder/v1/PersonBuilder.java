package com.ben.java.gof.creative_mode.builder.v1;

public class PersonBuilder {

    private Person person = new Person();

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder name(String name) {
        person.setName(name);
        return this;
    }

    public PersonBuilder age(Integer age) {
        person.setAge(age);
        return this;
    }

    public PersonBuilder gender(String gender) {
        person.setGender(gender);
        return this;
    }

    public PersonBuilder address(String address) {
        person.setAddress(address);
        return this;
    }

    public PersonBuilder hobby(String hobby) {
        person.setHobby(hobby);
        return this;
    }

    public Person build() {
        return this.person;
    }
}
