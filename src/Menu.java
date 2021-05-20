import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {


    }

    Scanner sc = new Scanner(System.in);
    //Accounting accounting = new Accounting();
    //Appication application = new Application();
    //Members members = new Members();

    public int getUserInput(){
        Scanner scanner = null;
        int userInput = scanner.nextInt();
        return userInput;
    }

    public void mainMenu() {
        System.out.println();
        System.out.println(">>>>>Welcome<<<<<");
        System.out.println("1 >>> Create member");
        System.out.println("2 >>> See memberlist");
        System.out.println("3 >>> See pricelist");
        System.out.println("4 >>> Exit");

        switch (getUserInput()) {
            case 1:
                System.out.println("You chose to create a member");
                System.out.println();
                break;
            case 2:
                //
                break;
            case 3:
                //
                break;
            case 4:
                //Exit program
            default:
                //User input an unexspedted choise.
        }
    }
    public void newMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter member name: ");
        String name = userInput.nextLine();

    }

}
