package members;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(MEMBER_LIST);
        Collections.reverse(MEMBER_LIST);

        int counter = 1;
        for (Member member: MEMBER_LIST) {
            System.out.print(counter + " - ");
            System.out.println(member);
            counter++;
        }
    }

    //this returns the index in the MEMBER_LIST based on the same of the searched for member
    public static int searchForMember(String name) {
        for (int i=0; i<MEMBER_LIST.size(); i++) {
            if(MEMBER_LIST.get(i).getName().equalsIgnoreCase(name)) {
                //MEMBER_LIST.get(i).printMember();
                return i;
            }
        }
        return -1;
    }

    //get arrayList
    public static ArrayList<Member> getMemberArrayList() {
        return MEMBER_LIST;
    }

}
