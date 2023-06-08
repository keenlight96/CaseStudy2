package com.main.companymanagementapp.user.sales;

import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.event.ActionEvent;

public class SalesPerson extends SalesStaff {
    public SalesPerson() {
    }

    public SalesPerson(String username, String password) {
        super(username, password);
    }

    public SalesPerson(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public long calculateSalary() {
        return getWorkDays()*450000;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event,Controller.SPControlPanelView);
    }
}
