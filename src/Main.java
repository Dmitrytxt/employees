import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final String fileName = System.getProperty("user.dir") + "\\data.dat";

    private static void outputEmployeesList() {
        for (Employee employee : employees) System.out.println(employee);
    }

    private static void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        int choice = 0;
        String specialization;
        while (choice != 1 && choice != 2) {
            System.out.println("Enter specialization\n1-engineer\n2-manager:");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            specialization = "engineer";
        } else {
            specialization = "manager";
        }
        scanner.nextLine();

        System.out.println("Enter position:");
        String position = scanner.nextLine();

        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter martial status:");
        String martialStatus = scanner.nextLine();

        System.out.println("Enter experience:");
        int experience = scanner.nextInt();
        scanner.nextLine();

        employees.add(new Employee(name, specialization, position, age, martialStatus, experience));
    }

    private static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();
        employees.removeIf(employee -> Objects.equals(employee.getName(), name));
    }

    private static void saveData() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Employee employee : employees) objectOutputStream.writeObject(employee);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void loadData() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object;
            while ((object = objectInputStream.readObject()) != null) {
                if (object instanceof Employee) employees.add((Employee) object);
            }
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);
        int menuChoice = -1;
        while (menuChoice != 0) {
            System.out.println("1-Add employee\n2-Employees list\n3-Delete employee\n0-Exit");
            menuChoice = scanner.nextInt();
            while (menuChoice > 3 || menuChoice < 0) menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1 -> addEmployee();
                case 2 -> outputEmployeesList();
                case 3 -> deleteEmployee();
                case 0 -> saveData();
            }
        }
    }
}
