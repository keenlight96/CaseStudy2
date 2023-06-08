package com.main.companymanagementapp.controller.user.sales;

import com.main.companymanagementapp.Main;
import com.main.companymanagementapp.controller.CheckInput;
import com.main.companymanagementapp.customer.Customer;
import com.main.companymanagementapp.customer.CustomerBuilder;
import com.main.companymanagementapp.product.Product;
import com.main.companymanagementapp.receipt.ReceiptBuilder;
import com.main.companymanagementapp.user.employer.President;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreateReceiptController implements Initializable {
    President president = (President) Main.userManagement.get(0);
    // Customer
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

    // Products at Store
    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, String> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> uomColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    @FXML
    private TableColumn<Product, Long> priceColumn;
    private ObservableList<Product> productList;

    // Products to Buy
    @FXML
    private TableView<Product> tableView1;
    @FXML
    private TableColumn<Product, String> idColumn1;
    @FXML
    private TableColumn<Product, String> nameColumn1;
    @FXML
    private TableColumn<Product, String> uomColumn1;
    @FXML
    private TableColumn<Product, Integer> quantityColumn1;
    @FXML
    private TableColumn<Product, Long> priceColumn1;
    @FXML
    private TableColumn<Product, Long> totalPriceColumn1;
    private ObservableList<Product> productList1;

    private List<Product> productsToBuyList = new ArrayList<>();
    @FXML
    private Label totalPayment;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Customer
        if (Main.customerManagement.size() == 0) {
            id.setText("1");
        } else {
            id.setText(String.valueOf(Main.customerManagement.get(Main.customerManagement.size() - 1).getId() + 1));
        }

        // Products at Store
        productList = FXCollections.observableArrayList(Main.productStoreManagement);
        idColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        uomColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("uom"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Long>("sellPrice"));
        tableView.setItems(productList);
        addButtonADDToTable();

        // Products to Buy
        productList1 = FXCollections.observableArrayList(productsToBuyList);
        idColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        nameColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        uomColumn1.setCellValueFactory(new PropertyValueFactory<Product, String>("uom"));
        quantityColumn1.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        priceColumn1.setCellValueFactory(new PropertyValueFactory<Product, Long>("sellPrice"));
        totalPriceColumn1.setCellValueFactory(new PropertyValueFactory<Product, Long>("totalSellPrice"));
        tableView1.setItems(productList1);
        addButtonREMOVEToTable();
        totalPayment.setText("0");

    }

    public boolean checkCustomerInformation() {
        boolean check = true;
        if (CheckInput.isValidString(phoneNumber.getText(), CheckInput.PHONE_NUMBER_PATTERN)) {
            if (CheckInput.isValidPhoneNumber(phoneNumber.getText(), Main.customerManagement)) {
                phoneNumberHint.setText("");
                if (Main.customerManagement.size() == 0) {
                    id.setText("1");
                } else {
                    id.setText(String.valueOf(Main.customerManagement.get(Main.customerManagement.size() - 1).getId() + 1));
                }
            } else {
                for (Customer e :
                        Main.customerManagement) {
                    if (e.getPhoneNumber().equals(phoneNumber.getText())) {
                        id.setText(String.valueOf(e.getId()));
                        name.setText(e.getName());
                        nameHint.setText("");
                        address.setText(e.getAddress());
                        return true;
                    }
                }
            }
        } else {
            check = false;
            phoneNumberHint.setText("Wrong phone number format");
        }

        if (CheckInput.isValidString(name.getText(), CheckInput.NAME_PATTERN)) {
            nameHint.setText("");
        } else {
            check = false;
            nameHint.setText("Each word must start with a CAPITAL character");
        }
        return check;
    }

    public void createReceipt(ActionEvent event) {
        if (checkCustomerInformation() && (Long.parseLong(totalPayment.getText()) != 0)) {
            // Get customer
            Customer customer = null;
            boolean check = false;
            for (Customer e :
                    Main.customerManagement) {
                if (e.getPhoneNumber().equals(phoneNumber.getText())) {
                    check = true;
                    customer = e;
                    break;
                }
            }
            if (!check){
                CustomerBuilder customerBuilder = new CustomerBuilder();
                customerBuilder.addName(name.getText())
                        .addPhoneNumber(phoneNumber.getText())
                        .addAddress(address.getText());
                customer = customerBuilder.build();
                Main.customerManagement.add(customer);
            }

            // Get receipt
            ReceiptBuilder builder = new ReceiptBuilder();
            builder.addCustomer(customer)
                    .addProducts(productsToBuyList)
                    .addTotalPrice(Long.parseLong(totalPayment.getText()));
            Main.receiptManagement.add(builder.build());
            customer.setTotalBuy(customer.getTotalBuy() + Long.parseLong(totalPayment.getText()));
            president.setCompanyFund(president.getCompanyFund() + Long.parseLong(totalPayment.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SUCCESS");
            alert.setHeaderText("A new receipt has been created");
            alert.setContentText("Total payment: " + totalPayment.getText());
            alert.showAndWait();
            Main.user.userControlPanel(event);
        }
    }

    private void addButtonADDToTable() {
        TableColumn<Product, Void> colBtn = new TableColumn("Add");

        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Add");

                    {
                        btn.setOnAction((ActionEvent event) -> addProduct(getTableView().getItems().get(getIndex())));
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

    private void addButtonREMOVEToTable() {
        TableColumn<Product, Void> colBtn = new TableColumn("Remove");

        Callback<TableColumn<Product, Void>, TableCell<Product, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Product, Void> call(final TableColumn<Product, Void> param) {
                final TableCell<Product, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("Remove");

                    {
                        btn.setOnAction((ActionEvent event) -> removeProduct(getTableView().getItems().get(getIndex())));
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

        tableView1.getColumns().add(colBtn);

    }

    public void updateBothTables() {
        productList.clear();
        productList.addAll(Main.productStoreManagement);
        tableView.refresh();

        productList1.clear();
        productList1.addAll(productsToBuyList);
        tableView1.refresh();
        long totalPaymentVar = 0;
        for (Product e :
                productsToBuyList) {
            totalPaymentVar += e.getTotalSellPrice();
        }
        totalPayment.setText(String.valueOf(totalPaymentVar));
    }

    public void addProduct(Product product) {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("ADDING");
        textInputDialog.setHeaderText("Add product to receipt");
        textInputDialog.setContentText("Enter quantity:");
        Optional<String> input = textInputDialog.showAndWait();
        try {
            int quantity = Integer.parseInt(input.get());
            if (quantity <= product.getQuantity()) {
                boolean check = false;
                for (Product e :
                        productsToBuyList) {
                    if (e.getId().equals(product.getId())) {
                        e.setQuantity(e.getQuantity() + quantity);
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    productsToBuyList.add(new Product(product.getId(), product.getName(), product.getUom(), quantity,
                            product.getBuyPrice(), product.getOrigin(), product.getDescription()));
                }
                product.setQuantity(product.getQuantity() - quantity);
                updateBothTables();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("FAILURE");
                alert.setHeaderText("Not enough products at store");
                alert.showAndWait();
            }
        } catch (Exception e) {
        }
    }

    public void removeProduct(Product product) {
        for (Product e :
                Main.productStoreManagement) {
            if (e.getId().equals(product.getId())) {
                e.setQuantity(e.getQuantity() + product.getQuantity());
                productsToBuyList.remove(product);
                updateBothTables();
                return;
            }
        }
    }

    public void back(ActionEvent event) {
        try {
            for (Product e :
                    productsToBuyList) {
                removeProduct(e);
            }
        } catch (Exception e){
        }
        Main.user.userControlPanel(event);
    }

}
