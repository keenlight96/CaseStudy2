package user;

import java.io.Serializable;

public abstract class Employee extends Person implements Serializable {
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(String username, String password) {
        super("","","","","");
        this.username = username;
        this.password = password;
    }

    public Employee(String id, String name, String phoneNumber, String address, String status, String username, String password) {
        super(id, name, phoneNumber, address, status);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public abstract void userControlPanel();

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
