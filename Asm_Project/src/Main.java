import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students");
            System.out.println("7. Exit");
            System.out.println("8. Add Random Students Automatically");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    management.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter ID of student to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    management.updateStudent(updateId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    String deleteId = scanner.nextLine();
                    management.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter ID of student to search: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = management.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    }
                    break;
                case 5:
                    management.displayStudents();
                    break;
                case 6:
                    System.out.print("Enter number of students to sort: ");
                    int numStudents = scanner.nextInt();
                    scanner.nextLine();
                    management.sortStudents(numStudents);
                    break;
                case 7:
                    exit = true;
                    break;
                case 8:
                    System.out.print("Enter the number of students to add: ");
                    int numStudentsToAdd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Adding " + numStudentsToAdd + " students automatically...");
                    long startTime = System.nanoTime();
                    addRandomStudents(management, numStudentsToAdd);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Time taken to add " + numStudentsToAdd + " students: " + duration + " nanoseconds");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void addRandomStudents(StudentManagement management, int count) {
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            String id = "S" + i;
            String name = "Student" + i;
            double marks = 1.0 + (random.nextDouble() * 9.0); // Marks between 1.0 and 10.0
            management.addStudent(new Student(id, name, marks));
        }
    }
}
