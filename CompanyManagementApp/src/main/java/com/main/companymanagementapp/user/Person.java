package com.main.companymanagementapp.user;

import com.main.companymanagementapp.Main;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String id;
    private String role;
    private String email;
    private String name;
    private String phoneNumber;
    private String address;
    private String status;

    public Person() {
    }

    public Person(String id, String name, String phoneNumber, String address, String status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleAcronym() {
        return switch (role) {
            case "President" -> "PR";
            case "Store Manager" -> "SM";
            case "Sales Person" -> "SP";
            case "Logistics Manager" -> "LM";
            case "Logistics Employee" -> "LE";
            case "Accountant" -> "AC";
            default -> "N/A";
        };
    }

    public void setId() {
        try {
            Main.idData.put(getRoleAcronym(), Main.idData.get(getRoleAcronym()) + 1);
            setId(getRoleAcronym() + Main.idData.get(getRoleAcronym()));
        } catch (Exception e) {
            Main.idData.put(getRoleAcronym(), 1);
            setId(getRoleAcronym() + 1);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
