package members;

import java.util.ArrayList;

public class MemberList {

    private static final ArrayList<Member> MEMBER_LIST = new ArrayList<>();

    //todo: ask Nicklas if this should be static like it is now
    public static void addMemberToList(Member member) {
        MEMBER_LIST.add(member);
    }

    //todo: ask Nicklas if this should be static like it is now
    public static void printMemberList() {
        for (Member member: MEMBER_LIST) {
            //member.printMember();
            System.out.println(member);
        }
    }

}
