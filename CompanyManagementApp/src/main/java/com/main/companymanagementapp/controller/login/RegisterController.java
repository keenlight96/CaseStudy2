package com.main.companymanagementapp.controller.login;

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

public class RegisterController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private Label usernameHint;
    @FXML
    private Label passwordHint;
    @FXML
    private Label confirmPasswordHint;
    @FXML
    private Label firstNameHint;
    @FXML
    private Label lastNameHint;
    @FXML
    private Label emailHint;
    @FXML
    private Label phoneNumberHint;
    @FXML
    private Label addressHint;

    // Role choice box
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Label roleHint;
    String[] roleList = Loader.getRoleList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(roleList);
    }

    public void register(ActionEvent event) {
        boolean check = true;
        if (CheckInput.isValidString(username.getText(), "^\\w[a-zA-Z0-9]{3,19}$")) {
            if (CheckInput.isValidUsername(username.getText(), Main.userManagement, Main.pendingManagement)) {
                usernameHint.setText("");
            } else {
                check = false;
                usernameHint.setText("Username has already existed");
            }
        } else {
            check = false;
            usernameHint.setText("Username must start with a word, contain 4 to 20 characters");
        }

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

        if (CheckInput.isValidString(firstName.getText(), CheckInput.NAME_PATTERN)) {
            firstNameHint.setText("");
        } else {
            check = false;
            firstNameHint.setText("Each word must start with a CAPITAL character");
        }

        if (CheckInput.isValidString(lastName.getText(), CheckInput.NAME_PATTERN)) {
            lastNameHint.setText("");
        } else {
            check = false;
            lastNameHint.setText("Each word must start with a CAPITAL character");
        }

        if (CheckInput.isValidString(email.getText(), CheckInput.EMAIL_PATTERN)) {
            if (CheckInput.isValidEmail(email.getText(), Main.userManagement, Main.pendingManagement)) {
                emailHint.setText("");
            } else {
                check = false;
                emailHint.setText("Email address has been registered");
            }
        } else {
            check = false;
            emailHint.setText("Wrong email address format");
        }

        if (CheckInput.isValidString(phoneNumber.getText(), CheckInput.PHONE_NUMBER_PATTERN)) {
            if (CheckInput.isValidPhoneNumber(phoneNumber.getText(), Main.userManagement, Main.pendingManagement)) {
                phoneNumberHint.setText("");
            } else {
                check = false;
                phoneNumberHint.setText("This phone number has been registered");
            }
        } else {
            check = false;
            phoneNumberHint.setText("Wrong phone number format");
        }

        if (role.getValue() != null) {
            if (role.getValue().equals("President") && (Main.userManagement.size() != 0)) {
                check = false;
                roleHint.setText("President already existed");
            } else {
                roleHint.setText("");
            }
        } else {
            check = false;
            roleHint.setText("Please choose your role");
        }

        // Check address (Reserve)

        if (check) {
            EmployeeBuilder builder = new EmployeeBuilder(role.getValue(), username.getText(), password.getText());
            if (role.getValue().equals("President"))
                builder.addId("PR");
            builder.addName(lastName.getText() + " " + firstName.getText())
                    .addEmail(email.getText())
                    .addPhoneNumber(phoneNumber.getText())
                    .addAddress(address.getText())
                    .addStatus("Active");
            Employee employee = builder.build();

            if (role.getValue().equals("President"))
                Main.userManagement.add(employee);
            else
                Main.pendingManagement.add(employee);

            System.out.println("Success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("REGISTER");
            alert.setHeaderText("You have been registered!");
            alert.showAndWait();

            Controller.switchScene(event, Controller.loginView);
        } else
            System.out.println("Re-enter wrong field");
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.loginView);
    }
}
