import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        mainMenu();


    }

    Scanner sc = new Scanner(System.in);
    //Accounting accounting = new Accounting();
    //Appication application = new Application();
    //Members members = new Members();

    public static int getUserInput(){
        Scanner scanner = null;
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
        System.out.println("1 ->> Create new member");
        System.out.println("2 ->> See memberlist");
        System.out.println("3 ->> See pricelist");
        System.out.println("4 ->> Exit program");

        switch (getUserInput()) {
            case 1:
                //Create member
                System.out.println("You chose to create a member");
                System.out.println();
                newMember();
                break;
            case 2:
                //See memberlist
                System.out.println("You chose to see memberlist");
                break;
            case 3:
                //See pricelist
                System.out.println("You chose to see pricelist");
                break;
            case 4:
                //Exit program
                System.out.println("You chose to exit program");
            default:
                //User input an unexspected choise.
                System.out.println("User input unexspected choise");
        }
    }
    public static void newMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter member name: ");
        String name = userInput.nextLine();

    }

}
