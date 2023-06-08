package com.main.companymanagementapp.controller.user.president;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.user.employer.President;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class PresidentCompanyFundController implements Initializable {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    @FXML
    private Label companyFund;
    @FXML
    private TextField money;
    private President president = ((President) Main.user);
    AlertInformation alert = new AlertInformation();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        companyFund.setText(numberFormat.format(president.getCompanyFund()));
    }

    public void deposit() {
        if (CheckInput.isValidLong(money.getText())) {
            president.setCompanyFund(president.getCompanyFund() + Long.parseLong(money.getText()));
            alert.show("SUCCESS","Deposited successfully","Company fund has raised by " +
                    numberFormat.format(Long.parseLong(money.getText())));
            companyFund.setText(numberFormat.format(president.getCompanyFund()));
            money.setText("");
        } else {
            alert.show("FAILURE","Wrong input format","");
            money.setText("");
        }
    }

    public void withdraw() {
        if (CheckInput.isValidLong(money.getText())) {
            if (Long.parseLong(money.getText()) <= president.getCompanyFund()) {
                president.setCompanyFund(president.getCompanyFund() - Long.parseLong(money.getText()));
                alert.show("SUCCESS","Withdrew successfully","Company fund has decreased by " +
                        numberFormat.format(Long.parseLong(money.getText())));
                companyFund.setText(numberFormat.format(president.getCompanyFund()));
                money.setText("");
            } else {
                alert.show("FAILURE", "Not enough money to withdraw","");
                money.setText("");
            }
        } else {
            alert.show("FAILURE","Wrong input format","");
            money.setText("");
        }
    }

    public void back(ActionEvent event){
        Main.user.userControlPanel(event);
    }
}
