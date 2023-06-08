package com.main.companymanagementapp.controller.user.president;

import com.main.companymanagementapp.controller.Controller;
import javafx.event.ActionEvent;

public class PresidentControlPanelController {
    public void toUserListController(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentUserListView);
    }

    public void toPendingListController(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentPendingListView);
    }

    public void toProductWarehouseListController(ActionEvent event){
        Controller.switchScene(event, Controller.productWarehouseView);
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

    public void toCompanyFundController(ActionEvent event) {
        Controller.switchScene(event, Controller.presidentCompanyFundView);
    }

    public void settings(ActionEvent event) {
        Controller.switchScene(event, Controller.settingsView);
    }

    public void logout(ActionEvent event) {
        Controller.switchScene(event, Controller.loginView);
    }
}
