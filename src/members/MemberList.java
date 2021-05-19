package members;

import java.util.ArrayList;

//@author Tobias Vinther
public class MemberList {

    private static final ArrayList<Member> MEMBER_LIST = new ArrayList<>();

    //todo: ask Nicklas if these should be static like it is now
    public static void addMemberToList(Member member) {
        MEMBER_LIST.add(member);
    }

    public static void deleteMemberFromList(Member member) {
        MEMBER_LIST.remove(member);
    }

    public static void printMemberList() {
        for (Member member: MEMBER_LIST) {
            //member.printMember();
            System.out.println(member);
        }
    }

    //todo: should this return a member instead?
    //search by name
    public static void searchForMember(String memberName) {
        for (Member member : MEMBER_LIST) {
            if(member.getName().equals(memberName)) {
                System.out.println(member);
            }
        }
    }

    //search by ID
    public static void searchForMember(int ID) {
        for (Member member : MEMBER_LIST) {
            if(member.getMemberID() == ID) {
                System.out.println(member);
            }
        }
    }
}
