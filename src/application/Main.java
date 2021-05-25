package application;

import accounting.*;
import members.Member;
import members.MemberList;
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

        Menu menu = new Menu();
        menu.mainMenu();

        /*
        PriceList priceList = new PriceList();
        Subscription subscription = new Subscription();

        MemberList.printMemberList();
        MemberList.searchForMember("Tobias Vinther");
        member1.printMember();
        Subscription.calculateSubscription();
        Subscription.hasNotPayed();
        subscription.checkFees();

        //testing writing to file
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeMembersToFile();

        //testing membership
        try {
            System.out.println(Membership.getMembership("Senior"));
        } catch (Exception e) {
            System.out.println("Medlemsskabet eksisterer ikke");;
        }
         */

    }
}
