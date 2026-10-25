import java.util.ArrayList;
import java.util.Scanner;

public class Student_Management_System {

    public static void displayMenu() {
        System.out.println();
        System.out.println("====== Welcome to Ash's Student Management System ======\n");
        System.out.println("Please select one of the following operations : \n");

        System.out.println("1.Display all students");
        System.out.println("2.Search student by ID");
        System.out.println("3.Add a new Student");
        System.out.println("4.Update student details");
        System.out.println("5.Delete a student's details");
        System.out.println("6.Exit");

    }

    public static void main(String args[]) {

        ArrayList<Student> arr = new ArrayList<>();
        int choice = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student(001, "Ash", 22, "B.Tech", 75.2);
        arr.add(s1);

        Student s2 = new Student(002, "Jocelyne", 21, "BCA", 66.1);
        arr.add(s2);

        do {
            displayMenu();

            System.out.println("Enter your choice : ");

            while(!sc.hasNextInt())
            {
                System.out.println("Please enter valid format !!");
                sc.next() ;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("The details of all students are as follows : \n");

                    for (Student s : arr) {
                        s.displayDetails();
                    }
                    break;
                }

                case 2: {
                    System.out.println("Please enter the ID that you want to search : ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid format of ID ! \nPlease enter a valid ID !");
                        sc.next();
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("The details of the searched ID are as follows : ");
                    StudentManager.searchId(id, arr);
                    break;
                }

                case 3: {
                    StudentManager.addStudent(arr, sc);
                    break;
                }

                case 4: {
                    System.out.println("Enter the ID of the student whose details you want to update : ");

                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid format of ID ! \nPlease enter a valid ID !");
                        sc.next();
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    StudentManager.updateStudent(id, arr, sc);
                    break;
                }

                case 5: {
                    System.out.println("Enter the ID of the student whose details you wish to remove : ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid format of ID ! \nPlease enter a valid ID !");
                        sc.next();
                    }
                    int id = sc.nextInt();
                    sc.nextLine();

                    StudentManager.deleteStudent(id, arr, sc);
                    break;
                }

                case 6: {
                    System.out.println("Thank you for your cooperation !!");
                    break;
                }

                default:
                    System.out.println("You have entered an invalid choice number ! \n Please select a choice from 1 to 6 !!\n");

            }
        } while (choice != 6);
    }
}
