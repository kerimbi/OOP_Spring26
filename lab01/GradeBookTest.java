import java.util.Scanner;
import java.util.ArrayList;

class Course {
    private String name;
    private String description;
    private int credits;
    private String[] prerequisites;
    
    public Course(String name, String description, int credits) {
        this.name = name;
        this.description = description;
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return name + " " + description;
    }
}

class GradeBook {
    private Course course;
    private ArrayList<Student> students;
    private ArrayList<Integer> grades;
    
    public GradeBook(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    
    public void addStudent(Student student, int grade) {
        students.add(student);
        grades.add(grade);
    }
    
    public void displayMessage() {
        System.out.println("Welcome to the grade book for " + course + "!");
    }
    
    public void displayGradeReport() {
        System.out.println();
        double average = determineClassAverage();
        System.out.printf("Class average is %.2f. ", average);
        
        findLowestGrade();
        findHighestGrade();
        
        System.out.println("\nGrades distribution:");
        outputBarChart();
    }
    
    public double determineClassAverage() {
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.size();
    }
    
    public void findLowestGrade() {
        int lowest = grades.get(0);
        int index = 0;
        
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
                index = i;
            }
        }
        
        System.out.print("Lowest grade is " + lowest + 
                        " (" + students.get(index).getName() + ", id: " + 
                        students.get(index).getId() + ").\n");
    }
    
    public void findHighestGrade() {
        int highest = grades.get(0);
        int index = 0;
        
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > highest) {
                highest = grades.get(i);
                index = i;
            }
        }
        
        System.out.print("Highest grade is " + highest + 
                        " (" + students.get(index).getName() + ", id: " + 
                        students.get(index).getId() + ").\n");
    }
    
    public void outputBarChart() {
        int[] distribution = new int[11];
        
        for (int grade : grades) {
            if (grade == 100) {
                distribution[10]++;
            } else {
                distribution[grade / 10]++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            for (int j = 0; j < distribution[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.print("  100: ");
        for (int j = 0; j < distribution[10]; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "GradeBook for " + course;
    }
}

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Course course = new Course("CS101", "Object-oriented Programming and Design", 3);
        GradeBook gradeBook = new GradeBook(course);
        
        gradeBook.displayMessage();
        System.out.println("Please, input grades for students:");
        
        Student studentA = new Student("A", 1);
        System.out.print("Student " + studentA.getName() + ": ");
        gradeBook.addStudent(studentA, scanner.nextInt());
        
        Student studentB = new Student("B", 4);
        System.out.print("Student " + studentB.getName() + ": ");
        gradeBook.addStudent(studentB, scanner.nextInt());
        
        Student studentC = new Student("C", 5);
        System.out.print("Student " + studentC.getName() + ": ");
        gradeBook.addStudent(studentC, scanner.nextInt());
        
        Student studentD = new Student("D", 87);
        System.out.print("Student " + studentD.getName() + ": ");
        gradeBook.addStudent(studentD, scanner.nextInt());
        
        Student studentE = new Student("E", 12);
        System.out.print("Student " + studentE.getName() + ": ");
        gradeBook.addStudent(studentE, scanner.nextInt());
        
        Student studentF = new Student("F", 23);
        System.out.print("Student " + studentF.getName() + ": ");
        gradeBook.addStudent(studentF, scanner.nextInt());
        
        Student studentG = new Student("G", 34);
        System.out.print("Student " + studentG.getName() + ": ");
        gradeBook.addStudent(studentG, scanner.nextInt());
        
        Student studentH = new Student("H", 45);
        System.out.print("Student " + studentH.getName() + ": ");
        gradeBook.addStudent(studentH, scanner.nextInt());
        
        Student studentI = new Student("I", 56);
        System.out.print("Student " + studentI.getName() + ": ");
        gradeBook.addStudent(studentI, scanner.nextInt());
        
        Student studentJ = new Student("J", 67);
        System.out.print("Student " + studentJ.getName() + ": ");
        gradeBook.addStudent(studentJ, scanner.nextInt());
        
        gradeBook.displayGradeReport();

    }
}