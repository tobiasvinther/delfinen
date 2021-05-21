package application;

import accounting.PriceList;
import accounting.Subscription;
import members.Member;
import members.MemberList;
import members.WriteToFile;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        //member tests
        Member member1 = new Member("Tobias Vinther", LocalDate.of(1985, 2, 1), "aktiv", "motionist");
        Member member2 = new Member("Flemming Nielsen", LocalDate.of(1994, 6, 11), "passiv", "");
        Member member3 = new Member("Anders Skovgaard", "16/08/1984", "passiv", "");
        Member member4 = new Member("Felix Vimmel", "16/08/2008", "aktiv", "konkurrencesvømmer");

        PriceList priceList = new PriceList();
        Subscription subscription = new Subscription();

        MemberList.printMemberList();
        MemberList.searchForMember("Tobias Vinther");
        member1.printMember();
        Subscription.calculateSubscription();
        Subscription.hasNotPayed();
        subscription.checkFees();

        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeMembersToFile();

    }
}
