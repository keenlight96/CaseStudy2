package com.main.companymanagementapp.controller;

import javafx.scene.control.Alert;

public class AlertInformation {
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public void show(String title, String header, String content){
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
