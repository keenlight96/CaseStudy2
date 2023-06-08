package com.main.companymanagementapp.controller.user.logistics.manager;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.controller.Controller;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.product.ProductBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddProductTypeController {
    @FXML
    private TextField id;
    @FXML
    private TextField name;
    @FXML
    private TextField uom;
    @FXML
    private TextField quantity;
    @FXML
    private TextField price;
    @FXML
    private TextField origin;
    @FXML
    private Label idHint;
    @FXML
    private Label nameHint;
    @FXML
    private Label uomHint;
    @FXML
    private Label quantityHint;
    @FXML
    private Label priceHint;
    @FXML
    private Label originHint;

    public void addProductType() {
        boolean check = true;
        if (CheckInput.isValidId(id.getText(),Main.productWarehouseManagement)) {
            idHint.setText("");
        } else {
            check = false;
            idHint.setText("Id has already existed");
        }

        if (CheckInput.isValidLong(price.getText())) {
            priceHint.setText("");
        } else {
            check = false;
            priceHint.setText("Not a number");
        }

        if (check) {
            ProductBuilder builder = new ProductBuilder();
            builder.addId(id.getText())
                    .addName(name.getText())
                    .addUom((uom.getText()))
                    .addQuantity(0)
                    .addBuyPrice(Long.parseLong(price.getText()))
                    .addOrigin(origin.getText())
                    .addDescription("");
            Product product = builder.build();

            Main.productWarehouseManagement.add(product);

            System.out.println("Success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PRODUCT");
            alert.setHeaderText("Product type has been added");
            alert.showAndWait();

            id.setText("");
            name.setText("");
            uom.setText("");
            price.setText("");
            origin.setText("");
        } else {
            System.out.println("Re-enter wrong fields");
        }
    }

    public void back(ActionEvent event) {
        Controller.switchScene(event, Controller.LMControlPanelView);
    }

}
