package accounting;

import members.*;

//@author Victor Vibe-Baasch
public class Subscription {

    public static void calculateSubscription() {

        double total = 0;
        for (int i = 0; i < MemberList.getMemberArrayList().size(); i++ ) {
            total = total + MemberList.getMemberArrayList().get(i).getMembershipFee();
        }
        System.out.println("The approximate income from fees this year is: " + total);
    }

    public static void hasNotPayed () {
        for (int i = 0; i < MemberList.getMemberArrayList().size(); i++) {
            if (MemberList.getMemberArrayList().get(i).isHasPaidMembership() != true ) {
                System.out.println("People who needs to pay" + MemberList.getMemberArrayList().get(i));
            }
        }
    }

    public static void checkFees () {
        System.out.println("Junior fee: " + Membership.getMembershipFee("Junior"));
        System.out.println("Passive fee: " + Membership.getMembershipFee("passivt"));
        System.out.println("Senior fee: " + Membership.getMembershipFee("Senior"));
        System.out.println("Over 60 years fee: " + Membership.getMembershipFee("Senior over 60"));
    }

}

