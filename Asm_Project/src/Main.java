import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(!exit) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}