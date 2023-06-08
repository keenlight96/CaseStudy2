package data;

import user.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Saver {
    public static File userDataFile = new File("src/data/userData.txt");
    public static File userPendingDataFile = new File("src/data/userPendingData.txt");

    public static void saveUserData(List<Employee> list, File file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
