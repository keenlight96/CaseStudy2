package com.main.companymanagementapp.controller.user.sales.manager;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class SMControlPanelController {
    AlertInformation alert = new AlertInformation();
    public void toSalesPersonController(ActionEvent event) {
        Controller.switchScene(event, Controller.SMSPListView);
    }

    public void toProductStoreController(ActionEvent event) {
        Controller.switchScene(event, Controller.productStoreView);
    }

    public void toCustomersController(ActionEvent event) {
        Controller.switchScene(event, Controller.customersListView);
    }

    public void toAllReceiptsController(ActionEvent event) {
        Controller.switchScene(event, Controller.allReceiptsListView);
    }

    public void toCreateCustomerController(ActionEvent event) {
        Controller.switchScene(event, Controller.createCustomerView);
    }

    public void toCreateReceiptController(ActionEvent event) {
        Controller.switchScene(event, Controller.createReceiptView);
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