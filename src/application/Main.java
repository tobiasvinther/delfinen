package application;

import members.Member;

public class Main {

    public static void main(String[] args) {

        Member member1 = new Member("Tobias Vinther", 36, "aktiv", "motionist");
        member1.printMember();

        Member member2 = new Member("Tobias Vinther", 36, "passiv", "");
        member2.printMember();

    }
}
