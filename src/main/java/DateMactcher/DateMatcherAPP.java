package DateMactcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DateMatcherAPP {



    public static void main(String[] args) throws InterruptedException {


        Scanner sc = new Scanner(System.in);
        int numberOfStudents;


        System.out.println("\nThis program matches students to each other for speed dates");
/*        TimeUnit.SECONDS.sleep(2);*/
        System.out.println("\nHow many students would you like to match?");
        numberOfStudents = sc.nextInt();

        List<Student> studentsList = collectStudentNames(numberOfStudents, sc);
/*        printStudentsInList(studentsList);*/

        DateMatcher dateMatchings = new DateMatcher(studentsList);

        System.out.println(dateMatchings);

        sc.close();

    }

    private static List collectStudentNames(int amountOfStudents, Scanner sc) {

        String currentStudentName;
        List<Student> studentsList = new ArrayList<Student>();
        int dateCount = 0;

        for ( int i = 0; i<amountOfStudents; i++){
            System.out.println("What is the name of student number " + ++dateCount + " ?");
            currentStudentName = sc.next();
            studentsList.add(new Student(currentStudentName));
        }

        return studentsList;
    }

    private static void printStudentsInList(List<Student> studentsList) {

        System.out.println();

        for ( Student s : studentsList){
            System.out.println(s.getName());
        }
    }
}
