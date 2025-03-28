import java.util.ArrayList;
import java.util.Scanner;

// Класс, представляющий студента
class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

// Класс для управления студентами
class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, int age, String id) {
        Student student = new Student(name, age, id);
        students.add(student);
    }

    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}

// Главный класс приложения
public class CRUD {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Считываем оставшийся символ новой строки

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    listStudents();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nStudent Management System");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. List all students");
        System.out.println("4. Find student by ID");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Считываем оставшийся символ новой строки
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        studentManager.addStudent(name, age, id);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() {
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine();

        if (studentManager.findStudentById(id) != null) {
            studentManager.removeStudent(id);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void listStudents() {
        System.out.println("Listing all students:");
        studentManager.listStudents();
    }

    private static void findStudent() {
        System.out.print("Enter student ID to find: ");
        String id = scanner.nextLine();

        Student student = studentManager.findStudentById(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }
}
