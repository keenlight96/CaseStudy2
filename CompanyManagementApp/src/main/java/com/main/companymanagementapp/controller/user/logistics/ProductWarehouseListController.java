package com.main.companymanagementapp.controller.user.logistics;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.product.Product;
import javafx.beans.property.SimpleStringProperty;
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
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductWarehouseListController implements Initializable {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product,String> uomColumn;
    @FXML
    private TableColumn<Product,Integer> quantityColumn;
    @FXML
    private TableColumn<Product, String> buyPriceColumn;
    @FXML
    private TableColumn<Product, String> totalBuyPriceColumn;
    @FXML
    private TableColumn<Product,String> originColumn;
    @FXML
    private TableColumn<Product,String> descriptionColumn;

    private ObservableList<Product> productList;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        productList = FXCollections.observableArrayList(Main.productWarehouseManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        uomColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("uom"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        buyPriceColumn.setCellValueFactory(cellData ->{
            Long buyPrice = cellData.getValue().getBuyPrice();
            if (buyPrice != 0) {
                return new SimpleStringProperty(numberFormat.format(buyPrice));
            }
            return new SimpleStringProperty("");
        });
        totalBuyPriceColumn.setCellValueFactory(cellData ->{
            Long totalBuyPrice = cellData.getValue().getTotalBuyPrice();
            if (totalBuyPrice != 0) {
                return new SimpleStringProperty(numberFormat.format(totalBuyPrice));
            }
            return new SimpleStringProperty("");
        });
        originColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("origin"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));

//        FilteredList<Product> filteredList = new FilteredList<>(productList);
//        filteredList.setPredicate(Product -> {
//            return (Product instanceof LogisticsStaff);
//        });
//
//        tableView.setItems(filteredList);
        tableView.setItems(productList);

//        addButtonToTable();
    }
    private void addButtonToTable() {
        TableColumn<Product, Void> colBtn = new TableColumn("Terminate");

        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<>() {

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

    public void terminate(String id) {
        // Add code here
        // Terminate in filteredList and also in employeeList
    }

    public void back(ActionEvent event) {
        Main.user.userControlPanel(event);
    }
}