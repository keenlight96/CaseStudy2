package com.main.companymanagementapp.controller.login;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.data.Loader;
import com.main.companymanagementapp.user.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void login(ActionEvent event) {
        boolean checkUsername = false, checkPassword = false;
        for (Employee e :
                Main.userManagement) {
            if (e.getUsername().equals(username.getText())) {
                checkUsername = true;
                if (e.getPassword().equals(password.getText())) {
                    checkPassword = true;
                    Main.user = e;
                    e.userControlPanel(event);
                }
            }
        }
        if (!checkUsername)
            System.out.println("User doesn't exist");
        else if (!checkPassword)
            System.out.println("Wrong password");
        else
            System.out.println("Login successfully");
    }

    public void register(ActionEvent event) {
        Controller.switchScene(event, Controller.registerView);
    }
}
