package com.main.companymanagementapp.controller.user.logistics;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.AlertInformation;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.user.employer.President;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class ImportProductController {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    @FXML
    private TextField id;
    @FXML
    private TextField quantity;
    @FXML
    private Label idHint;
    @FXML
    private Label quantityHint;

    AlertInformation alert = new AlertInformation();
    President president = (President) Main.userManagement.get(0);

    public void importProducts() {
        boolean check1 = true;
        boolean check2 = false;
        if (CheckInput.isValidInteger(quantity.getText())) {
            quantityHint.setText("");
        } else {
            check1 = false;
            quantityHint.setText("Not a number");
        }

        for (Product e :
                Main.productWarehouseManagement) {
            if (e.getId().equals(id.getText())) {
                check2 = true;
                idHint.setText("");
                break;
            }
        }

        if (!check2) {
            idHint.setText("Id doesn't exist");
        } else {
            idHint.setText("");
        }

        if (check1 && check2) {
            for (Product e :
                    Main.productWarehouseManagement) {
                if (e.getId().equals(id.getText())) {
                    if (e.getBuyPrice() * Integer.parseInt(quantity.getText()) <= president.getCompanyFund()) {
                        System.out.println("OK");
                        e.setQuantity(e.getQuantity() + Integer.parseInt(quantity.getText()));
                        president.setCompanyFund(president.getCompanyFund() - e.getBuyPrice() * Integer.parseInt(quantity.getText()));
                        alert.show("SUCCESS","Products have been imported to warehouse",
                                "Total cost is " + numberFormat.format(e.getBuyPrice() * Integer.parseInt(quantity.getText())));
                    } else {
                        alert.show("FAILURE","President said company fund has not enough","");
                    }
                    id.setText("");
                    quantity.setText("");
                    break;
                }
            }
        }
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }

}
