import java.util.Scanner;

public class Menu {

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
        System.out.println("-----Welcome-----");
        System.out.println("Press 1 to create member");
        System.out.println("Press 2 to see memberlist");
        System.out.println("Press 3 to see pricelist");

        switch (getUserInput()) {
            case 1:
                System.out.println("You chose to create a member");
                System.out.println();

        }
    }

}
