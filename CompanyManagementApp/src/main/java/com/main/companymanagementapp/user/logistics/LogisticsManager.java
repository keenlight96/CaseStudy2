package com.main.companymanagementapp.user.logistics;

import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.event.ActionEvent;

public class LogisticsManager extends LogisticsStaff {
    public LogisticsManager() {
    }

    public LogisticsManager(String username, String password) {
        super(username, password);
    }

    public LogisticsManager(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public long calculateSalary() {
        return getWorkDays()*500000;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event, Controller.LMControlPanelView);
    }
}
