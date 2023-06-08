package com.main.companymanagementapp.user.sales;

import com.main.companymanagementapp.user.Employee;

import java.io.Serializable;

public abstract class SalesStaff extends Employee {
    public SalesStaff() {
    }

    public SalesStaff(String username, String password) {
        super(username, password);
    }

    public SalesStaff(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    public abstract long calculateSalary();

}
