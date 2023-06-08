package user.sales;

import user.Employee;

public class SalesPerson extends SalesStaff {
    public SalesPerson() {
    }

    public SalesPerson(String username, String password) {
        super(username, password);
    }

    public SalesPerson(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
