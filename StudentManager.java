import java.util.ArrayList;
import java.util.Scanner;

class StudentManager {

    public static Student searchStudentById(int id, ArrayList<Student> arr) {
        for (Student s : arr) {
            if (s.getId() == id)
                return s;
        }

        return null;

    }

    public static void searchId(int id, ArrayList<Student> arr) {

        Student s0 = searchStudentById(id, arr);

        if (s0 != null)
            s0.displayDetails();

        else
            System.out.println("No such user with Id exists !! \n Kindly recheck the given Id . \n");

    }

    public static void displayUpdateMenu() {
        System.out.println("Select the information you want to modify : \n");
        System.out.println("  ===== Update Student ===== \n");
        System.out.println("1.Update Student Name");
        System.out.println("2.Update Student Age");
        System.out.println("3.Update Student Course");
        System.out.println("4.Update Student Marks");
        System.out.println("5.Return to Main Menu");

        System.out.println("______________________________________________________________________");

    }

    public static void addStudent(ArrayList<Student> arr, Scanner sc) {

        System.out.println("Please enter the ID of the student that you want to add : ");
        while (!sc.hasNextInt()) {
            System.out.println("Enter valid format !!");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();

        Student s0 = searchStudentById(id, arr);

        if (s0 != null) {
            System.out.println("User with this Id already exists !!");
        }

        else {

            System.out.println("Enter Name : ");

            String name = sc.nextLine();
            while (name.isBlank()) {
                System.out.println("Please enter valid name : ");
                name = sc.nextLine();
            }

            System.out.println("Enter age : ");
            while (!sc.hasNextInt()) {
                System.out.println("Enter valid format !! ");
                sc.next();
            }
            int age = sc.nextInt();
            sc.nextLine();
            while (age <= 0 || age > 100) {
                System.out.println("Please enter valid age !! ");
                System.out.println("Enter age : ");
                while (!sc.hasNextInt()) {
                    System.out.println("Enter valid format !! ");
                    sc.next();
                }
                age = sc.nextInt();
                sc.nextLine();
            }

            System.out.println("Enter course : ");
            String course = sc.nextLine();

            while (course.isBlank()) {
                System.out.println("Course field cannot be empty ! \n Please enter a course !!\n");
                course = sc.nextLine();
            }

            System.out.println("Enter marks : ");
            while (!sc.hasNextDouble()) {
                System.out.println("Enter valid format !! \n");
                sc.next();
            }
            double marks = sc.nextDouble();
            
            while (marks < 0 || marks > 100) {
                System.out.println("Please enter valid marks !! \n");
                System.out.println("Enter marks : ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Enter valid format !! \n");
                    sc.next();
                }
                marks = sc.nextDouble();
                sc.nextLine() ;
            }

            Student s1 = new Student(id, name, age, course, marks);
            arr.add(s1);
            System.out.println("Student with given ID has been added !! \n");
        }
    }

    public static void updateStudent(int id, ArrayList<Student> arr, Scanner sc) {

        Student s0 = searchStudentById(id, arr);

        if (s0 == null)
            System.out.println("No student found with ID : " + id);

        else {

            int choice;
            do {

                displayUpdateMenu();

                System.out.println("Enter your choice : ");

                while (!sc.hasNextInt()) {
                    System.out.println("Enter valid choice from 1 to 5 ! \n");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.println("Enter the updated name : ");
                        String updatedName = sc.nextLine();
                        while (updatedName.isBlank()) {
                            System.out.println("Name cannot be empty !! Enter valid name : ");
                            updatedName = sc.nextLine();
                        }

                        s0.setName(updatedName);
                        System.out.println("Name updated successfully !!");

                        break;
                    }

                    case 2: {
                        System.out.println("Enter the updated age : ");

                        while (!sc.hasNextInt()) {
                            System.out.println("Please enter valid format ! \n");
                            sc.next();
                        }

                        int updatedAge = sc.nextInt();
                        while (updatedAge <= 0 || updatedAge > 100) {
                            System.out.println("Please enter valid age : ");

                            while (!sc.hasNextInt()) {
                                System.out.println("Please enter valid format !");
                                sc.next();
                            }

                            updatedAge = sc.nextInt();
                        }

                        s0.setAge(updatedAge);
                        System.out.println("Age has been updated successfully !!");
                        break;
                    }

                    case 3: {
                        System.out.println("Please enter the updated course : ");

                        String updatedCourse = sc.nextLine();
                        while (updatedCourse.isBlank()) {
                            System.out.println("Enter valid Course ! ");
                            updatedCourse = sc.nextLine();
                        }

                        s0.setCourse(updatedCourse);

                        System.out.println("Course has been updated successfully !!");
                        break;
                    }
                    case 4: {
                        System.out.println("Enter the updated marks : ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Please enter valid format !");
                            sc.next();
                        }
                        double updatedMarks = sc.nextDouble();

                        while (updatedMarks < 0 || updatedMarks > 100) {
                            System.out.println("Please enter valid marks !!");
                            System.out.println("Enter the updated marks : ");
                            while (!sc.hasNextDouble()) {
                                System.out.println("Please enter valid format !");
                                sc.next();
                            }
                            updatedMarks = sc.nextDouble();

                        }

                        s0.setMarks(updatedMarks);

                        System.out.println("Marks have been updated successfuly !!");
                        break;
                    }

                    case 5: {
                        System.out.println("Returning back to Main Menu !! \n");
                        break;
                    }

                    default:
                        System.out.println("Invalid choice ! Please enter a choice from 1 to 5 .");
                }
            } while (choice != 5);

        }
    }

    public static void deleteStudent(int id, ArrayList<Student> arr, Scanner sc) {

        Student s0 = searchStudentById(id, arr);

        if (s0 != null) {

            System.out.println("Are you sure to delete the student with the ID " + id + " ?");
            System.out.println("Choose Y/N : ");

            String input = sc.nextLine();
            char in;

            while (input.isEmpty() || (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("N"))) {
                System.out.println("Please choose a value : Y/N : ");
                input = sc.nextLine().trim();

            }

            in = input.charAt(0);

            if (in == 'Y' || in == 'y') {

                arr.remove(s0);
                System.out.println("Student was deleted !!");

            } else
                System.out.println("Student was not deleted !! \n");
        } else
            System.out.println("No user with given ID exists ! \nKindly Recheck the entered ID !!\n");
    }
}