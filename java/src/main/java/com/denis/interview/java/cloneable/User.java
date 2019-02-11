package com.denis.interview.java.cloneable;

import java.util.Date;

public class User implements Cloneable {

    private String name;
    private String lastName;
    private Date birthDate;

    public User(String name, String lastName, Date birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User customClone() {
        return new User(this.name, this.lastName, this.birthDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
