package com.main.companymanagementapp.controller.user.sales;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.customer.CustomerBuilder;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.product.ProductBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable {
    @FXML
    private Label id;
    @FXML
    private TextField name;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private Label idHint;
    @FXML
    private Label nameHint;
    @FXML
    private Label phoneNumberHint;
    @FXML
    private Label addressHint;

    public void createCustomer() {
        boolean check = true;
        if (CheckInput.isValidString(name.getText(), CheckInput.NAME_PATTERN)) {
            nameHint.setText("");
        } else {
            check = false;
            nameHint.setText("Each word must start with a CAPITAL character");
        }

        if (CheckInput.isValidString(phoneNumber.getText(), CheckInput.PHONE_NUMBER_PATTERN)) {
            if (CheckInput.isValidPhoneNumber(phoneNumber.getText(), Main.customerManagement)) {
                phoneNumberHint.setText("");
            } else {
                check = false;
                phoneNumberHint.setText("This phone number has been registered");
            }
        } else {
            check = false;
            phoneNumberHint.setText("Wrong phone number format");
        }

        if (check) {
            CustomerBuilder builder  = new CustomerBuilder();
            builder.addName(name.getText())
                    .addPhoneNumber(phoneNumber.getText())
                    .addAddress(address.getText());
            Customer customer = builder.build();
            Main.customerManagement.add(customer);

            id.setText(String.valueOf(Main.customerManagement.get(Main.customerManagement.size() - 1).getId() + 1));
            name.setText("");
            phoneNumber.setText("");
            address.setText("");
            nameHint.setText("");
            phoneNumberHint.setText("");
            addressHint.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CREATE");
            alert.setHeaderText("A new customer information has been added");
            alert.showAndWait();
        }
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Main.customerManagement.size() == 0) {
            id.setText("1");
        } else {
            id.setText(String.valueOf(Main.customerManagement.get(Main.customerManagement.size() - 1).getId() + 1));
        }
    }
}
