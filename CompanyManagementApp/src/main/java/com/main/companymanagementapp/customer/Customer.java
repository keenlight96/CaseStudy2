package com.main.companymanagementapp.customer;

import com.main.companymanagementapp.Main;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id = 0;
    private String name;
    private String phoneNumber;
    private String address;
    private long totalBuy;

    public Customer() {
        if (Main.customerManagement.size() == 0) {
            id = 1;
        } else {
            id = Main.customerManagement.get(Main.customerManagement.size() - 1).getId() + 1;
        }
    }

    public Customer(int id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(long totalBuy) {
        this.totalBuy = totalBuy;
    }
}
