package labs.h4.hot_or_cold;

import java.util.Scanner;

public class HotOrColdApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println("What season is it? ");

        choice = sc.nextLine().trim();
        Season season = Season.valueOf(choice.toUpperCase());

        switch (season){
            case SPRING:
                System.out.println(Season.SPRING.toString());
                break;
            case SUMMER:
                System.out.println(Season.SUMMER.toString());
                break;
            case AUTUMN:
                System.out.println(Season.AUTUMN.toString());
                break;
            case WINTER:
                System.out.println(Season.WINTER.toString());;
                break;
            default:
                System.out.println("unknown");
        }
    }
}
