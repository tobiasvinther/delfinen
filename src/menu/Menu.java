package menu;

import Controller.Controller;
import members.Member;
import members.MemberList;
import java.util.Scanner;

public class Menu {

    private static Controller controller = new Controller();

    public int getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return userInput;
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|         Velkommen!       |");
        System.out.println("|     Delfinen Svømmeklub  |");
        System.out.println("+--------------------------+");
        System.out.println("Dine muligheder: ");
        System.out.println("1 ->> Opret nyt medlem");
        System.out.println("2 ->> Søg på medlem");
        System.out.println("3 ->> Se medlemsliste");
        System.out.println("4 ->> Se årlige indtjening");
        System.out.println("5 ->> Se liste over medlemmer der er i restance");
        System.out.println("6 ->> Se kontingentsatser");
        System.out.println("7 ->> Rediger kontingentsatser");
        System.out.println("0 ->> Afslut program");

        switch (getUserInput()) {
            case 1:
                //Opret medlem
                System.out.println("Du valgte at oprette et nyt medlem");
                System.out.println();
                newMember();
                break;
            case 2:
                //Se medlem
                System.out.println("Du valgte at søge efter et medlem");
                System.out.println();
                searchMember();
                break;
            case 3:
                //Se medlemsliste
                System.out.println("Du valgte at se medlemsliste");
                System.out.println();
                memberListMenu();
                break;
            case 4:
                //Se årlige indtjening
                System.out.println("Du valgte at se på årlige indtjening");
                //controller.calculateSubcription();
                break;
            case 5:
                //Se liste over medlemmer der er i restance.
                System.out.println("Du valgte at se listen over medlemmer der er i restance");
                //Svært at se hvilken klasse den skal hentes fra.
                break;
            case 6:
                //Se kontingentsatser.
                System.out.println("Du kan nu se kontingentsatserne");
                editMembershipFees();

                //controller.PriceList();
                break;
            case 7:
                //Rediger kontingentsatser.
                System.out.println("Du kan nu redigere i kontingentsatserne");
                editMembershipFees();
            case 0:
                break;
            default:
                //Tastning eksistere ikke, prøv igen!
                System.out.println("Uønsket tastning! Prøv igen!");
                mainMenu();
        }
    }
    //todo: why does this create two members?
    public void newMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Tast navn: ");
        String name = userInput.nextLine();
        System.out.println("Tast fødselsdag (dd/mm/yyyy): ");
        String birthday = userInput.nextLine();
        System.out.println("Tast email: ");
        String email = userInput.nextLine();
        System.out.println("Tast medlemsskabtype (aktiv eller passiv medlemsskab): ");
        String membershiptype = userInput.nextLine();
        System.out.println("Tast activity type(motionist eller konkurrencesvømmer): ");
        String activityType = userInput.nextLine();
        Member newMember = new Member(name, birthday, email, membershiptype, activityType);
        //controller.newMember(newMember);
        //userInput.nextLine();
        System.out.println("Medlem oprettet");
        mainMenu();
    }

    public void searchMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Tast navn: ");
        String name = userInput.nextLine();
        int memberIndex = MemberList.searchForMember(name);
        memberMenu(memberIndex);
        //selectFromSearchResults(name);
        //controller.searchForMember(name);

    }
    /*
    public static void selectFromSearchResults(String name) {
        System.out.println("Vælg et medlem");
        int chosenMemberIndex = getUserInput();
        //MemberList.searchForMember(name)
        MemberList.getMemberArrayList().get(chosenMemberIndex-1).printMember();
        //this doesn't work right now...
    }
     */

    /*
    public static void editOrDeleteMember() {
        System.out.println("Du har nu følgende muligheder:");
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
            default:
                //Tastning eksistere ikke, prøv igen.
                System.out.println("Uønsket tastning! Prøv igen!");
                mainMenu();

        }
    }
     */

    public void editMembershipFees() {
        Scanner userInput = new Scanner(System.in);
        controller.printMemberships();
        System.out.println("Du har nu følgende valgmuligheder:");
        System.out.println("1 ->> Redigér passivt medlemsskab");
        System.out.println("2 ->> Redigér junior medlemsskab");
        System.out.println("3 ->> Redigér senior medlemsskab");
        System.out.println("4 ->> Redigér rabat 60+ år");
        System.out.println("0 ->> Tilbage til hovedmenu");
        double newFee;

        switch (getUserInput()) {
            case 1:
                //Rediger passiv medlemsskab.
                System.out.println("Indtast ny sats for passivt medlemsskab: ");
                newFee = userInput.nextDouble();
                controller.setMembershipFee("passivt", newFee);
                editMembershipFees();
                break;
            case 2:
                //Rediger juniormedlemsskab.
                System.out.println("Indtast ny sats for juniormedlemsskab: ");
                newFee = userInput.nextDouble();
                controller.setMembershipFee("junior", newFee);
                editMembershipFees();
                break;
            case 3:
                //Redigere seniormedlemsskab.
                System.out.println("Indtast ny sats for seniormedlemsskab: ");
                newFee = userInput.nextDouble();
                controller.setMembershipFee("senior", newFee);
                editMembershipFees();
                break;
            case 4: //todo: finish
                //Over 60 år rabat.
                System.out.println("Indtast ny rabat (eks. 25% = 0,75): ");
                newFee = userInput.nextDouble();
                controller.setOver60Discount(newFee);
                editMembershipFees();
                break;
            case 0:
                mainMenu();
                break;
            default:
                //Tastning eksistere ikke, prøv igen.
                System.out.println("Uønsket tastning! Prøv igen!");
                mainMenu();

        }
    }
    public void memberListMenu() {
        controller.printMemberList();
        System.out.println("x ->> Vælg et medlem");
        System.out.println("0 ->> Tilbage til hovedmenuen");
        System.out.println("999 ->> Eksportér medlemslisten til fil");

        int chosenMemberIndex = getUserInput();

        if(chosenMemberIndex == 0) {
            mainMenu();
        } else if (chosenMemberIndex == 999) {
            controller.exportMemberListToFile();
            System.out.println("Medlemsliste eksporteret");
            memberListMenu();
        } else memberMenu(chosenMemberIndex-1);

    }

    public void memberMenu(int memberIndex) {
        controller.printMember(memberIndex);
        System.out.println("1 ->> Redigér navn");
        System.out.println("2 ->> Redigér email");
        System.out.println("3 ->> Redigér medlemskab");
        System.out.println("4 ->> Redigér aktivitetstype");
        System.out.println("5 ->> Slet medlem");
        System.out.println("6 ->> Tilbage til medlemsliste");
        System.out.println("0 ->> Tilbage til hovedmenu");
        Scanner userInput = new Scanner(System.in);

        switch (getUserInput()) {

            case 1:
                System.out.println("Indtast nyt navn: ");
                String newName = userInput.nextLine();
                controller.editName(MemberList.getMemberArrayList().get(memberIndex), newName); //todo: change to go through controller?
                memberMenu(memberIndex);
                break;
            case 2:
                System.out.println("Indtast ny email: ");
                String newEmail = userInput.nextLine();
                controller.editEmail(MemberList.getMemberArrayList().get(memberIndex), newEmail); //todo: change to go through controller?
                memberMenu(memberIndex);
                break;
            case 3: //this could be made better if the user just chose between active and passive and the system did the rest
                System.out.println("Indtast nyt medlemskabstype (aktiv/passiv)");
                String newMembership = userInput.nextLine();
                controller.editMembershipType(MemberList.getMemberArrayList().get(memberIndex), newMembership);
                //MemberList.getMemberArrayList().get(memberIndex).setMembershipType(newMembership);
                //String newMembershipType = userInput.nextLine();
                //controller.editEmail(MemberList.getMemberArrayList().get(memberIndex), newEmail); //todo: change to go through controller?
                memberMenu(memberIndex);
                break;
            case 4:
                System.out.println("Indtast ny aktivitetstype (motionist eller konkurrencesvømmer): ");
                String newActivityType = userInput.nextLine();
                controller.editActivityType(MemberList.getMemberArrayList().get(memberIndex), newActivityType); //todo: change to go through controller?
                memberMenu(memberIndex);
                break;
            case 5:
                controller.deleteMember(MemberList.getMemberArrayList().get(memberIndex));
                System.out.println("Medlem slettet");
                memberListMenu();
                break;
            case 6:
                memberListMenu();
                break;
            case 0:
                mainMenu();
                break;
        }
    }
}
