package DateMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO: comments
 * TODO: Proper string token parsing
 * TODO: Error handling?
 */
public class DateMatcherView {

    private Scanner sc;

    public DateMatcherView() {
        this.sc = new Scanner(System.in);
        mainMenu();
    }

    public void mainMenu(){

        int numberOfStudents;

        System.out.println("\nThis program matches students to each other for speed dates");
        System.out.println("\nHow many students would you like to match?");
        numberOfStudents = Integer.parseInt(sc.nextLine());

        SpeedDateList dateMatches = new SpeedDateList(collectStudentNames(numberOfStudents, sc));

        System.out.println(dateMatches);

        sc.close();
    }

    public List<Student> collectStudentNames(int amountOfStudents, Scanner sc){

        String currentStudentName;
        List<Student> studentsList = new ArrayList<Student>();
        int prefixNumber = 0;

        for ( int i = 0; i<amountOfStudents; i++ ){
            System.out.println("What is the name of student number " + ++prefixNumber + " ?");
            currentStudentName = sc.next();
            studentsList.add(new Student(currentStudentName));
        }

        return studentsList;
    }

    public void printStudentsInList(List<Student> studentsList) {

        System.out.println();

        for ( Student s : studentsList){
            System.out.println(s.getName());
        }
    }
}
