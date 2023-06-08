package com.main.companymanagementapp.controller.user.logistics.employee;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.product.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MoveProductController {
    @FXML
    private TextField id;
    @FXML
    private TextField quantity;
    @FXML
    private Label idHint;
    @FXML
    private Label quantityHint;

    public void moveProduct() {
        boolean check = true;
        if (!CheckInput.isValidId(id.getText(),Main.productWarehouseManagement)) {
            idHint.setText("");
        } else {
            check = false;
            idHint.setText("ID doesn't exist");
        }
        if (CheckInput.isValidInteger(quantity.getText())) {
            quantityHint.setText("");
            for (Product e :
                    Main.productWarehouseManagement) {
                if (e.getId().equals(id.getText())) {
                    if (e.getQuantity() >= Integer.parseInt(quantity.getText())) {
                        e.setQuantity(e.getQuantity() - Integer.parseInt(quantity.getText()));
                        if (!CheckInput.isValidId(id.getText(),Main.productStoreManagement)) {
                            for (Product e2 :
                                    Main.productStoreManagement) {
                                if (e2.getId().equals(id.getText())) {
                                    e2.setQuantity(e2.getQuantity() + Integer.parseInt(quantity.getText()));
                                    System.out.println("append");
                                    break;
                                }
                            }
                        } else {
                            Main.productStoreManagement.add(new Product(e.getId(),e.getName(),e.getUom(),
                                    Integer.parseInt(quantity.getText()),e.getBuyPrice(),e.getOrigin(),e.getDescription()));
                            System.out.println("add new");
                        }
                    } else {
                        check = false;
                        quantityHint.setText("Not enough products at warehouse");
                    }
                    break;
                }
            }
        } else {
            check = false;
            quantityHint.setText("Not a number");
        }

        if (check) {
            id.setText("");
            quantity.setText("");
            idHint.setText("");
            quantityHint.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("MOVE PRODUCT");
            alert.setHeaderText("Products have been moved");
            alert.showAndWait();
        }
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }
}
