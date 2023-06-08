package data;

import user.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static File userDataFile = new File("src/data/userData.txt");
    public static File userPendingDataFile = new File("src/data/userPendingData.txt");
    public static List<Employee> loadUserData(File file) {
        List<Employee> list = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Employee>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
