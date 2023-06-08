package user.logistics;

import user.Employee;

public class LogisticsManager extends LogisticsStaff {
    public LogisticsManager() {
    }

    public LogisticsManager(String username, String password) {
        super(username, password);
    }

    public LogisticsManager(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
