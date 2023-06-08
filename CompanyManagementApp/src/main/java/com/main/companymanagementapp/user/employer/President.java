package com.main.companymanagementapp.user.employer;

import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.user.Employee;
import javafx.event.ActionEvent;

public class President extends Employee {
    private long companyFund = 0;

    public President() {
    }

    public President(String username, String password) {
        super(username, password);
    }

    public President(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super("PR001", name, phoneNumber, address, status, username, password);
    }

    public long getCompanyFund() {
        return companyFund;
    }

    public void setCompanyFund(long companyFund) {
        this.companyFund = companyFund;
    }

    @Override
    public void userControlPanel(ActionEvent event) {
        Controller.switchScene(event,Controller.presidentControlPanelView);
    }

    @Override
    public long calculateSalary() {
        return 0;
    }
}
