package com.main.companymanagementapp.controller.user.finance.accountant;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class ACControlPanelController {
    AlertInformation alert = new AlertInformation();
    public void toUserListController(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentUserListView);
    }

    public void toAllReceiptsController(ActionEvent event) {
        Controller.switchScene(event, Controller.allReceiptsListView);
    }

    public void calculateSalary(ActionEvent event) {
        Controller.switchScene(event, Controller.ACSalaryView);
    }

    public void checkin(){
        Main.user.checkin();
        alert.show("CHECKIN","You have checked in. Total worked days: " + Main.user.getWorkDays(),"");
    }

    public void settings(ActionEvent event) {
        Controller.switchScene(event, Controller.settingsView);
    }

    public void logout(ActionEvent event) {
        Controller.switchScene(event, Controller.loginView);
    }
}
