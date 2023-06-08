package com.main.companymanagementapp.user.logistics;

import com.main.companymanagementapp.user.Employee;

public abstract class LogisticsStaff extends Employee {
    public LogisticsStaff() {
    }

    public LogisticsStaff(String username, String password) {
        super(username, password);
    }

    public LogisticsStaff(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    public abstract long calculateSalary();
}
