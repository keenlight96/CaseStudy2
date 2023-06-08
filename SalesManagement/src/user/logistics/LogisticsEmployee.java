package user.logistics;

public class LogisticsEmployee extends LogisticsStaff{
    public LogisticsEmployee() {
    }

    public LogisticsEmployee(String username, String password) {
        super(username, password);
    }

    public LogisticsEmployee(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status, username, password);
    }

    @Override
    public void userControlPanel() {

    }
}
