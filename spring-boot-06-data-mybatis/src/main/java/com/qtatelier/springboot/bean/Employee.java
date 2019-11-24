package com.qtatelier.springboot.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author JazzXia
 * @create 2019-10-19:40
 */
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getLastName(), employee.getLastName()) &&
                Objects.equals(getGender(), employee.getGender()) &&
                Objects.equals(getEmail(), employee.getEmail()) &&
                Objects.equals(getdId(), employee.getdId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLastName(), getGender(), getEmail(), getdId());
    }
}
