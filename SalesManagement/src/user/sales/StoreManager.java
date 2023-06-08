package user.sales;

import java.io.Serializable;

public class StoreManager extends SalesStaff implements Serializable {
    public StoreManager() {
    }

    public StoreManager(String username, String password) {
        super(username, password);
    }

    public StoreManager(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
