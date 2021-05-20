package application;

import accounting.Subscription;
import members.Member;
import members.MemberList;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        //member tests
        Member member1 = new Member("Tobias Vinther", LocalDate.of(1985, 2, 1), "aktiv", "motionist");
        Member member2 = new Member("Flemming Nielsen", LocalDate.of(1994, 6, 11), "passiv", "");
        Member member3 = new Member("Anders Skovgaard", "16/08/1984", "passiv", "");

        MemberList.printMemberList();
        MemberList.searchForMember("Tobias Vinther");
        member1.printMember();
        Subscription.calculateSubscription();

    }
}
