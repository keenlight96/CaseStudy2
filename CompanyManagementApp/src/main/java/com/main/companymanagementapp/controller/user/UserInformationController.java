package com.main.companymanagementapp.controller.user;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.data.Loader;
import com.main.companymanagementapp.user.Employee;
import com.main.companymanagementapp.user.EmployeeBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UserInformationController implements Initializable {
    @FXML
    private Label id;
    @FXML
    private Label username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private Label phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private Label passwordHint;
    @FXML
    private Label confirmPasswordHint;
    @FXML
    private Label nameHint;
    @FXML
    private Label emailHint;
    @FXML
    private Label phoneNumberHint;
    @FXML
    private Label addressHint;
    @FXML
    private Label role;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setText(Main.user.getId());
        role.setText(Main.user.getRole());
        username.setText(Main.user.getUsername());
        password.setText(Main.user.getPassword());
        confirmPassword.setText(Main.user.getPassword());
        name.setText(Main.user.getName());
        email.setText(Main.user.getEmail());
        phoneNumber.setText(Main.user.getPhoneNumber());
        address.setText(Main.user.getAddress());

    }

    public void saveChange(ActionEvent event) {
        boolean check = true;
        if (CheckInput.isValidString(password.getText(), "^\\w{3,}$")) {
            passwordHint.setText("");
        } else {
            check = false;
            passwordHint.setText("Must contain at least 3 characters");
        }

        if (password.getText().equals(confirmPassword.getText())) {
            confirmPasswordHint.setText("");
        } else {
            check = false;
            confirmPasswordHint.setText("Password doesn't match");
        }

        if (CheckInput.isValidString(name.getText(), CheckInput.NAME_PATTERN)) {
            nameHint.setText("");
        } else {
            check = false;
            nameHint.setText("Each word must start with a CAPITAL character");
        }

        if (CheckInput.isValidString(email.getText(), CheckInput.EMAIL_PATTERN)) {
            if (CheckInput.isValidEmail(email.getText(), Main.userManagement, Main.pendingManagement) ||
                    (email.getText().equals(Main.user.getEmail()))) {
                emailHint.setText("");
            }else {
                check = false;
                emailHint.setText("Email address has been registered");
            }
        } else {
            check = false;
            emailHint.setText("Wrong email address format");
        }

        if (check) {
            Main.user.setPassword(password.getText());
            Main.user.setName(name.getText());
            Main.user.setEmail(email.getText());
            Main.user.setAddress(address.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SAVE");
            alert.setHeaderText("Save changes successfully");
            alert.showAndWait();

        } else
            System.out.println("Re-enter wrong field");
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }
}
