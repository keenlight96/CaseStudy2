package com.main.companymanagementapp.controller.user.logistics.employee;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class LEControlPanelController {
    AlertInformation alert = new AlertInformation();
    public void toProductWarehouseListController(ActionEvent event){
        Controller.switchScene(event, Controller.productWarehouseView);
    }

    public void toImportProductController(ActionEvent event){
        Controller.switchScene(event, Controller.importProductView);
    }

    public void toMoveProductController(ActionEvent event){
        Controller.switchScene(event, Controller.moveProductView);
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
