package com.main.companymanagementapp.user.logistics;

import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;

public class LogisticsEmployee extends LogisticsStaff{
    public LogisticsEmployee() {
    }

    public LogisticsEmployee(String username, String password) {
        super(username, password);
    }

    public LogisticsEmployee(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public long calculateSalary() {
        return getWorkDays()*450000;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event, Controller.LEControlPanelView);
    }
}
