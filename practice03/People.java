package practice03;

import java.util.HashSet;
import java.util.Scanner;

public class People {
    public static void main(String[] args) {
        HashSet<Person> persons = new HashSet<>();
        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add a new person");
            System.out.println("2. Print info about all persons");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("What type of person?");
                System.out.println("1. Person  2. Student  3. Staff");
                int type = in.nextInt();
                in.nextLine();

                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Address: ");
                String address = in.nextLine();

                if (type == 1) {
                    persons.add(new Person(name, address));

                } else if (type == 2) {
                    System.out.print("Program: ");
                    String program = in.nextLine();
                    System.out.print("Year: ");
                    int year = in.nextInt();
                    System.out.print("Fee: ");
                    double fee = in.nextDouble();
                    in.nextLine();
                    persons.add(new Student(name, address, program, year, fee));

                } else if (type == 3) {
                    System.out.print("School: ");
                    String school = in.nextLine();
                    System.out.print("Pay: ");
                    double pay = in.nextDouble();
                    in.nextLine();
                    persons.add(new Staff(name, address, school, pay));
                }

                System.out.println("Person added successfully!");

            } else if (choice == 2) {
                if (persons.isEmpty()) {
                    System.out.println("No persons added yet.");
                } else {
                    System.out.println("All People: ");
                    for (Person p : persons) {
                        System.out.println(p);
                    }
                }
            }

        } while (choice != 3);

        System.out.println("EXIT");

    }
}