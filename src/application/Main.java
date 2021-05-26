package application;

import accounting.*;
import members.Member;
import members.WriteToFile;
import menu.Menu;

public class Main {

    public static void main(String[] args) {
        //importing the list of membership fees csv
        Membership.importPriceList();

        //instantiating some members
        Member member1 = new Member("Tobias Vinther", "01/02/1985", "test@email.dk", "aktiv", "motionist");
        Member member2 = new Member("Flemming Nielsen", "13/12/1994", "test@email.dk", "passiv", "motionist");
        Member member3 = new Member("Anders Skovgaard", "16/08/1984", "test@email.dk", "passiv", "motionist");
        Member member4 = new Member("Felix Vimmel", "16/08/2008", "test@email.dk","aktiv", "konkurrencesvømmer");

        //set at least one member to not have paid membership fee
        member4.setHasPaidMembership(false);

        //run main menu
        Menu menu = new Menu();
        menu.mainMenu();

        /*
        //testing membership
        try {
            System.out.println(Membership.getMembership("Senior"));
        } catch (Exception e) {
            System.out.println("Medlemsskabet eksisterer ikke");;
        }
         */
    }
}
