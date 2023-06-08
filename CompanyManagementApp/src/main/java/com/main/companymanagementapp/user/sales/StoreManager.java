package com.main.companymanagementapp.user.sales;

import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;

public class StoreManager extends SalesStaff {
    public StoreManager() {
    }

    public StoreManager(String username, String password) {
        super(username, password);
    }

    public StoreManager(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public long calculateSalary() {
        return getWorkDays()*600000;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event,Controller.SMControlPanelView);
    }


    public void logout(ActionEvent event) {
        Controller.switchScene(event, Controller.loginView);
    }
}
