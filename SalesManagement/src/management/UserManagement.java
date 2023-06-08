package management;

import controller.ValidateInput;
import data.Loader;
import data.Saver;
import user.Employee;
import user.employer.President;
import user.finance.FinanceEmployee;
import user.finance.FinanceManager;
import user.logistics.LogisticsEmployee;
import user.logistics.LogisticsManager;
import user.sales.SalesPerson;
import user.sales.StoreManager;

import java.util.List;
import java.util.Scanner;

public class UserManagement {
    Scanner scanner = new Scanner(System.in);
    List<Employee> userManagement = Loader.loadUserData(Loader.userDataFile);
    List<Employee> pendingManagement = Loader.loadUserData(Loader.userPendingDataFile);
    String username, password, id, name, phoneNumber, address, status;

    public UserManagement() {
    }

    public void mainControlPanel() {
        int choice;
        while (true) {
            userManagement = Loader.loadUserData(Loader.userDataFile);
            pendingManagement = Loader.loadUserData(Loader.userPendingDataFile);
            System.out.println("----------------");
            System.out.println("1. Register");
            System.out.println("2. Login");

            choice = ValidateInput.inputInteger("choice", 0, 2);
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public int getMaxPendingId() {
        int max = 0;
        for (Employee e :
                pendingManagement) {
            try {
                if (Integer.parseInt(e.getId()) > max)
                    max = Integer.parseInt(e.getId());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return max;
    }

    public void registerInput() {
        username = ValidateInput.inputUsername(userManagement, pendingManagement);
        password = ValidateInput.inputString("password", ".*");
        id = String.valueOf(getMaxPendingId() + 1);
        name = ValidateInput.inputString("name", "^([A-Z][a-z]* )*[A-Z][a-z]*$");
        phoneNumber = ValidateInput.inputString("phone number", "^0[1-9][0-9]{8}");
        address = ValidateInput.inputString("address", ".*");
        status = "pending";
    }

    public void register() {
        while (true) {
            int choice, choice2;
            System.out.println("1. Logistics");
            System.out.println("2. Sales");
            System.out.println("3. Finance");
            choice = ValidateInput.inputInteger("choice", 0, 4);

            switch (choice) {
                case 1:
                    System.out.println("1. Logistics Manager");
                    System.out.println("2. Logistics Employee");
                    choice2 = ValidateInput.inputInteger("choice", 0, 2);

                    if (choice2 == 0)
                        break;
                    registerInput();
                    switch (choice2) {
                        case 1:
                            pendingManagement.add(new LogisticsManager(id, name, phoneNumber, address, status, username, password));
                            break;
                        case 2:
                            pendingManagement.add(new LogisticsEmployee(id, name, phoneNumber, address, status, username, password));
                            break;
                    }
                    Saver.saveUserData(pendingManagement, Saver.userPendingDataFile);
                    break;
                case 2:
                    System.out.println("1. Store Manager");
                    System.out.println("2. Sales Person");
                    choice2 = ValidateInput.inputInteger("choice", 0, 2);

                    if (choice2 == 0)
                        break;
                    registerInput();

                    switch (choice2) {
                        case 1:
                            pendingManagement.add(new StoreManager(id, name, phoneNumber, address, status, username, password));
                            break;
                        case 2:
                            pendingManagement.add(new SalesPerson(id, name, phoneNumber, address, status, username, password));
                            break;
                    }
                    Saver.saveUserData(pendingManagement, Saver.userPendingDataFile);
                    break;
                case 3:
                    System.out.println("1. Finance Manager");
                    System.out.println("2. Finance Employee");
                    choice2 = ValidateInput.inputInteger("choice", 0, 2);

                    if (choice2 == 0)
                        break;
                    registerInput();

                    switch (choice2) {
                        case 1:
                            pendingManagement.add(new FinanceManager(id, name, phoneNumber, address, status, username, password));
                            break;
                        case 2:
                            pendingManagement.add(new FinanceEmployee(id, name, phoneNumber, address, status, username, password));
                            break;
                    }
                    Saver.saveUserData(pendingManagement, Saver.userPendingDataFile);
                    break;

                case 4:
                    System.out.println("Admin");
                    registerInput();
                    userManagement.add(new President(id, name, phoneNumber, address, status, username, password));
                    Saver.saveUserData(userManagement, Saver.userDataFile);
                    break;

                case 0:
                    return;
            }
        }
    }

    public void login() {
        Employee employee = null;
        boolean checkUsername = false;
        boolean checkPassword = false;
        String username = ValidateInput.inputString("username", "^\\w.{4,15}$");
        String password = ValidateInput.inputString("password", ".*");
        for (Employee e :
                userManagement) {
            if (e.getUsername().equals(username)) {
                checkUsername = true;
                if (e.getPassword().equals(password)) {
                    employee = e;
                    checkPassword = true;
                }
                break;
            }
        }
        if (!checkUsername)
            System.out.println("Username doesn't exist");
        else {
            if (!checkPassword)
                System.out.println("Wrong password");
            else
                employee.userControlPanel();
        }
    }


}













