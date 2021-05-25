package Menu;

import members.Member;
import members.MemberList;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Member member1 = new Member("Tobias Vinther", LocalDate.of(1985, 2, 1), "aktiv", "motionist");
        Member member2 = new Member("Flemming Nielsen", LocalDate.of(1994, 6, 11), "passiv", "");
        Member member3 = new Member("Anders Skovgaard", "16/08/1984", "test@email.dk", "passiv", "");
        Member member4 = new Member("Felix Vimmel", "16/08/2008", "test@email.dk","aktiv", "konkurrencesvømmer");
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
        System.out.println("2 ->> Søg på medlem");
        System.out.println("3 ->> Se medlemsliste: ");
        System.out.println("4 ->> Rediger eller slet medlem");
        System.out.println("5 ->> Se årlige indtjening: ");
        System.out.println("6 ->> Se liste over medlemmer der er i restance: ");
        System.out.println("7 ->> Se kontingentsatser: ");
        System.out.println("8 ->> rediger kontingentsatser: ");
        System.out.println(" ->> Afslut program");


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
                //controller.Member;
                searchMember();
                break;
            case 3:
                //Se medlemsliste
                System.out.println("Du valgte at se medlemsliste");
                System.out.println();
                memberListMenu();
                //controller.printMemberList();
                break;
            case 4:
                //Rediger eller slet medlem
                System.out.println("Du valgte at redigere eller slette et medlem");
                editOrDeleteMember();
                break;
            case 5:
                //Se årlige indtjening
                System.out.println("Du valgte at se på årlige indtjening");
                //controller.calculateSubcription();
                break;
            case 6:
                //Se liste over medlemmer der er i restance.
                System.out.println("Du valgte at se listen over medlemmer der er i restance");
                //Svært at se hvilken klasse den skal hentes fra.
                break;
            case 7:
                //Se kontingentsatser.
                System.out.println("Du kan nu se kontingentsatserne");
                //controller.PriceList();
                break;
            case 8:
                //Rediger kontingentsatser.
                System.out.println("Du kan nu redigere i kontingentsatserne");
                redigerKontingentpriserne();
            default:
                //Tastning eksistere ikke, prøv igen!
                System.out.println("uønsket tastning! prøv igen!");
                mainMenu();
        }
    }
    public static void newMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Tast navn: ");
        String name = userInput.nextLine();
        System.out.println("Tast fødselsdag (dd-mm-yyyy): ");
        String birthday = userInput.nextLine();
        System.out.println("Tast email: ");
        String email = userInput.nextLine();
        System.out.println("Tast medlemsskabtype (aktiv eller passiv medlemsskab): ");
        String membershiptype = userInput.nextLine();
        System.out.println("Tast activity type(motionist or competitive): ");
        String activityType = userInput.nextLine();
        Member newMember = new Member(name, birthday, email, membershiptype, activityType);
        //controller.newMember(newMember);
        mainMenu();

    }
    public static void searchMember() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Tast navn: ");
        String name = userInput.nextLine();
        MemberList.searchForMember(name);
        selectFromSearchResults(name);
        //controller.searchForMember(name);

    }
    public static void selectFromSearchResults(String name) {
        System.out.println("Vælg et medlem");
        int chosenMemberIndex = getUserInput();
        //MemberList.searchForMember(name)
        MemberList.getMemberArrayList().get(chosenMemberIndex-1).printMember();
        //todo: how to get this to work.
    }


    public static void editOrDeleteMember() {
        System.out.println("Du har nu følgende muligheder: ");
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
    public static void redigerKontingentpriserne() {
        System.out.println("Du har nu følgende valgmuligheder: ");
        System.out.println("Tryk 1 for at redigere passivt medlemsskab:");
        System.out.println("Tryk 2 for at redigere junior medlemsskab: ");
        System.out.println("Tryk 3 for at redigere senior medlemsskab: ");
        System.out.println("Tryk 4 for at redigere rabat 60+ år: ");
        System.out.println("Tryk 5 for at redigere 60+ år medlemsskab");

        switch (getUserInput()) {
            case 1:
                //Rediger passiv medlemsskab.
                System.out.println("Du valgte at redigere passivt medlemsskab ");
                //controller.getPassivFee();
                break;
            case 2:
                //Rediger juniormedlemsskab.
                System.out.println("Du valgte at redigere juniormedlemsskab ");
                //controller.getJuniorFee();
                break;
            case 3:
                //Redigere seniormedlemsskab.
                System.out.println("Du valgte at redigere seniormedlemsskab ");
                //controller.getSeniorFee();
                break;
            case 4:
                //Over 60 år rabat.
                System.out.println("Du valgte at redigere rabat til 60+ ");
                //controller.getOver60Fee();
                break;
            case 5:
                //Redigere 60+ medlemsskab.
                System.out.println("Du valgte at redigere medlemsskab for 60+ ");
                //controller.getOver60Fee();
                break;
            default:
                //Tastning eksistere ikke, prøv igen.
                System.out.println("Uønsket tastning! Prøv igen!");
                mainMenu();

        }
    }
    public static void memberListMenu() {
        System.out.println("Vælg et medlem");
        int chosenMemberIndex = getUserInput()-1;
        //controller.printMember(chosenMemberIndex);

        /*MemberList.printMemberList();
        int chosenMemberIndex = getUserInput();
        MemberList.getMemberArrayList().get(chosenMemberIndex-1).printMember();*/
        //todo: should go through the controller.

    }


}
