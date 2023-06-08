package com.main.companymanagementapp.user;

import com.main.companymanagementapp.user.employer.President;
import com.main.companymanagementapp.user.finance.Accountant;
import com.main.companymanagementapp.user.logistics.LogisticsEmployee;
import com.main.companymanagementapp.user.logistics.LogisticsManager;
import com.main.companymanagementapp.user.sales.SalesPerson;
import com.main.companymanagementapp.user.sales.StoreManager;

public class EmployeeBuilder {
    Employee employee;

    public EmployeeBuilder(String role, String username, String password) {
        switch (role) {
            case "President" -> employee = new President(username, password);
            case "Store Manager" -> employee = new StoreManager(username, password);
            case "Sales Person" -> employee = new SalesPerson(username, password);
            case "Logistics Manager" -> employee = new LogisticsManager(username, password);
            case "Logistics Employee" -> employee = new LogisticsEmployee(username, password);
            case "Accountant" -> employee = new Accountant(username, password);
        }

        employee.setRole(role);
    }

    public EmployeeBuilder addId(String id) {
        employee.setId(id);
        return this;
    }

    public EmployeeBuilder addName(String name) {
        employee.setName(name);
        return this;
    }

    public EmployeeBuilder addEmail(String email) {
        employee.setEmail(email);
        return this;
    }

    public EmployeeBuilder addPhoneNumber(String phoneNumber){
        employee.setPhoneNumber(phoneNumber);
        return this;
    }

    public EmployeeBuilder addAddress(String address) {
        employee.setAddress(address);
        return this;
    }

    public EmployeeBuilder addStatus(String status) {
        employee.setStatus(status);
        return this;
    }

    public Employee build(){
        return employee;
    }
}
