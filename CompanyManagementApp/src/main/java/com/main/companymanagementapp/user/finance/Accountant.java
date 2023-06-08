package com.main.companymanagementapp.user.finance;

import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;

public class Accountant extends FinanceStaff{
    public Accountant() {
    }

    public Accountant(String username, String password) {
        super(username, password);
    }

    public Accountant(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public long calculateSalary() {
        return getWorkDays()*600000;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event, Controller.ACControlPanelView);
    }
}
