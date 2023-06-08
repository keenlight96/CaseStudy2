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

public class ImportProductController {
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

//        for (Product e :
//                Main.productWarehouseManagement) {
//            if (e.getId().equals(id.getText())) {
//                if (check1) {
//                    e.setQuantity(e.getQuantity() + Integer.parseInt(quantity.getText()));
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("SUCCESS");
//                    alert.setHeaderText("Products have been imported to warehouse");
//                    alert.setContentText("Total cost is " + e.getPrice()*Integer.parseInt(quantity.getText()));
//                    alert.showAndWait();
//                    check2 = true;
//
//                    id.setText("");
//                    quantity.setText("");
//                    break;
//                }
//            }
//        }
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
                                "Total cost is " + e.getBuyPrice() * Integer.parseInt(quantity.getText()));
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
