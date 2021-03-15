package dateMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO: comments
 * TODO: Proper string token parsing
 * TODO: Error handling?
 * TODO: looped menu
 * TODO: Datingrooms
 */
public class DateMatcherView {

    private Scanner sc;

    public DateMatcherView() {
        this.sc = new Scanner(System.in);
        mainMenu();
    }

    public void mainMenu(){


        int menuChoice = -1;
        final int amountOfMenuOptions = 2;

        boolean exitProgram = false;

        System.out.println("\nThis program matches students to each other for speed dates");

        while (!exitProgram){
            do {
                System.out.println("\nWhat would you like to do?(pick a number followed by enter)");
                System.out.println("(1). Match students");
                System.out.println("(2). Exit this program");

                try{
                    menuChoice = Integer.parseInt(sc.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Please input a whole natural number thats between 1 and " + amountOfMenuOptions);
                }
            } while (menuChoice < 1 || menuChoice > amountOfMenuOptions);

            switch (menuChoice){
                case 1: matchStudentsMenu();
                    break;
                case 2: exitProgram = true;
                    break;
                default:
                    break;
            }

            if (exitProgram){
                sc.close();
            }
        }

    }


    public void matchStudentsMenu(){

        int numberOfStudents = 0;
        boolean inputValid = false;

        do {
            try {
                System.out.println("\nHow many students would you like to match?");
                numberOfStudents = Integer.parseInt(sc.nextLine());
                inputValid = (numberOfStudents > 2) ? true : false;
            } catch (NumberFormatException e){
                System.out.println("Please input a natural whole number that is higher than 2");
            }
        } while (!inputValid && numberOfStudents > 2 );


        SpeedDateList dateMatches = new SpeedDateList(collectStudentNames(numberOfStudents, sc));
        System.out.println(dateMatches);
    }


    public List<Student> collectStudentNames(int amountOfStudents, Scanner sc){

        String currentStudentName;
        List<Student> studentsList = new ArrayList<>();
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
