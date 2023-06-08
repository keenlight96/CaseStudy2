package com.main.companymanagementapp.controller.user.sales.manager;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.receipt.Receipt;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class AllReceiptsListController implements Initializable {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    @FXML
    private TableView<Receipt> tableView;
    @FXML
    private TableColumn<Receipt, Integer> idColumn;
    @FXML
    private TableColumn<Receipt, String> nameColumn;
    @FXML
    private TableColumn<Receipt, String> phoneNumberColumn;
    @FXML
    private TableColumn<Receipt, String> productColumn;
    @FXML
    private TableColumn<Receipt, String> idProductColumn;
    @FXML
    private TableColumn<Receipt, String> nameProductColumn;
    @FXML
    private TableColumn<Receipt, String> uomProductColumn;
    @FXML
    private TableColumn<Receipt, String> quantityProductColumn;
    @FXML
    private TableColumn<Receipt, String> priceProductColumn;
    @FXML
    private TableColumn<Receipt, Long> totalPriceColumn;
    @FXML
    private TableColumn<Receipt, String> originColumn;
    @FXML
    private TableColumn<Receipt, String> descriptionColumn;

    private ObservableList<Receipt> receiptsList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        receiptsList = FXCollections.observableArrayList(Main.receiptManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Receipt, Integer>("id"));
        nameColumn.setCellValueFactory(cellData -> {
            Customer customer = cellData.getValue().getCustomer();
            if (customer != null) {
                return new SimpleStringProperty(customer.getName());
            }
            return new SimpleStringProperty("");
        });
        phoneNumberColumn.setCellValueFactory(cellData -> {
            Customer customer = cellData.getValue().getCustomer();
            if (customer != null) {
                return new SimpleStringProperty(customer.getPhoneNumber());
            }
            return new SimpleStringProperty("");
        });
//        productColumn.setCellValueFactory(cellData -> {
//            String productString = "";
//            List<Product> list = cellData.getValue().getProducts();
//            if (list != null) {
//                for (Product e :
//                        list) {
//                    productString += String.format("%4s%20s%5s%-5d%-12d\n",e.getId(),e.getName(), e.getUom(),e.getQuantity(),e.getSellPrice());
//                }
//                return new SimpleStringProperty(productString);
//            }
//            return new SimpleStringProperty("");
//        });
        idProductColumn.setCellValueFactory(cellData -> {
            String productString = "";
            List<Product> list = cellData.getValue().getProducts();
            if (list != null) {
                for (Product e :
                        list) {
                    productString += e.getId() + "\n";
                }
                return new SimpleStringProperty(productString);
            }
            return new SimpleStringProperty("");
        });
        nameProductColumn.setCellValueFactory(cellData -> {
            String productString = "";
            List<Product> list = cellData.getValue().getProducts();
            if (list != null) {
                for (Product e :
                        list) {
                    productString += e.getName() + "\n";
                }
                return new SimpleStringProperty(productString);
            }
            return new SimpleStringProperty("");
        });
        uomProductColumn.setCellValueFactory(cellData -> {
            String productString = "";
            List<Product> list = cellData.getValue().getProducts();
            if (list != null) {
                for (Product e :
                        list) {
                    productString += e.getUom() + "\n";
                }
                return new SimpleStringProperty(productString);
            }
            return new SimpleStringProperty("");
        });
        quantityProductColumn.setCellValueFactory(cellData -> {
            String productString = "";
            List<Product> list = cellData.getValue().getProducts();
            if (list != null) {
                for (Product e :
                        list) {
                    productString += e.getQuantity() + "\n";
                }
                return new SimpleStringProperty(productString);
            }
            return new SimpleStringProperty("");
        });
        priceProductColumn.setCellValueFactory(cellData -> {
            String productString = "";
            List<Product> list = cellData.getValue().getProducts();
            if (list != null) {
                for (Product e :
                        list) {
                    productString += e.getSellPrice() + "\n";
                }
                return new SimpleStringProperty(productString);
            }
            return new SimpleStringProperty("");
        });
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<Receipt, Long>("totalPrice"));

//        FilteredList<Product> filteredList = new FilteredList<>(productList);
//        filteredList.setPredicate(Product -> {
//            return (Product instanceof LogisticsStaff);
//        });
//
//        tableView.setItems(filteredList);
        tableView.setItems(receiptsList);
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }
}