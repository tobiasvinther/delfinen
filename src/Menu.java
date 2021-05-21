import members.Member;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        mainMenu();


    }

    public static int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return userInput;
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|         Welcome          |");
        System.out.println("|     Menu Application     |");
        System.out.println("+--------------------------+");
        System.out.println("Please make a selection: ");
        System.out.println("1 ->> Opret nyt medlem");
        System.out.println("2 ->> Se medlem");
        System.out.println("3 ->> Se medlemsliste: ");
        System.out.println("4 ->> Rediger eller slet medlem");
        System.out.println("5 ->> Se årlige indtjening: ");
        System.out.println("6 ->> Se liste over medlemmer der er i restance: ");
        System.out.println("7 ->> Se kontingentsatser: ");
        System.out.println("8 ->> rediger kontingentsatser: ");
        System.out.println(" ->> Afslut program");


        switch (getUserInput()) {
            case 1:
                //Create member
                System.out.println("Du valgte at oprette et nyt medlem");
                System.out.println();
                newMember();
                break;
            case 2:
                //See memberlist
                System.out.println("Du valgte at se søge efter medlem");
                System.out.println();
                //controller.Member;
                mainMenu();
                break;
            case 3:
                //Rediger eller slet medlem
                System.out.println("Du valgte at se medlemsliste");
                System.out.println();
                //controller.getMemberArraylist();
                mainMenu();
                break;
            case 4:
                //Rediger eller slet medlem
                System.out.println("Du valgte at redigere eller slette medlem");
                editOrDeleteMember();
                mainMenu();
                break;
            case 5:
                //Afslut program
                System.out.println("Program afsluttet!");
            default:
                //User input an unexspected choise.
                System.out.println("uønsket tastning!");
        }
    }
    public static void newMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter member name: ");
        String name = userInput.nextLine();
        System.out.println("Enter dd-mm-yyyy: ");
        String birthday = userInput.nextLine();
        System.out.println("Enter (active or passive membership): ");
        String membershiptype = userInput.nextLine();
        System.out.println("Enter activity type(motionist or competitive): ");
        String activityType = userInput.nextLine();
        Member newMember = new Member(name, birthday, membershiptype, activityType );
        //controller.newMember(newMember);

    }
    public static void editOrDeleteMember() {
        System.out.println("Rediger medlem: ");
        System.out.println("Slet medlem: ");

        switch (getUserInput()) {
            case 1:
                //Rediger medlem
                System.out.println("Du valgte at redigere et medlem");
                //controller.Member();
                break;
            case 2:
                //Slet medlem
                System.out.println("Du valgte at slette et medlem");
                //controller.Member

        }


    }

}
