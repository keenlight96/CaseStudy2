package com.main.companymanagementapp.user;

import javafx.event.ActionEvent;

import java.io.Serializable;

public abstract class Employee extends Person implements Serializable {
    private String username;
    private String password;

    private int workDays = 0;
    private long salary = 0;
    private long totalSalary = 0;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public void checkin() {
        setWorkDays(getWorkDays() + 1);
    }

    public void resetCheckin() {
        setWorkDays(0);
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(long totalSalary) {
        this.totalSalary = totalSalary;
    }

    public abstract void userControlPanel(ActionEvent event);
    public abstract long calculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
