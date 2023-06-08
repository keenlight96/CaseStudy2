package com.main.companymanagementapp.controller.user.sales;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerListController implements Initializable {
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, Integer> idColumn;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer,String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer,String> addressColumn;
    @FXML
    private TableColumn<Customer, Long> totalBuyColumn;
    @FXML
    private TableColumn<Customer,String> originColumn;
    @FXML
    private TableColumn<Customer,String> descriptionColumn;

    private ObservableList<Customer> customerList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        customerList = FXCollections.observableArrayList(Main.customerManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNumber"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        totalBuyColumn.setCellValueFactory(new PropertyValueFactory<Customer, Long>("totalBuy"));

//        FilteredList<Product> filteredList = new FilteredList<>(productList);
//        filteredList.setPredicate(Product -> {
//            return (Product instanceof LogisticsStaff);
//        });
//
//        tableView.setItems(filteredList);
        tableView.setItems(customerList);

        addButtonToTable();
    }
    private void addButtonToTable() {
        TableColumn<Customer, Void> colBtn = new TableColumn("Terminate");

        Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Customer, Void> call(final TableColumn<Customer, Void> param) {
                final TableCell<Customer, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Terminate");

                    {
                        btn.setOnAction((ActionEvent event) -> terminate(getTableView().getItems().get(getIndex()).getId()));
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }

    public void terminate(int id) {
        // Add code here
        // Terminate in filteredList and also in employeeList
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }
}