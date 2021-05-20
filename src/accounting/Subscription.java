package accounting;

import members.*;

public class Subscription {

    public static void calculateSubscription() {

        double total = 0;
        for (int i = 0; i < MemberList.getMemberArrayList().size(); i++ ) {
            total = total + MemberList.getMemberArrayList().get(i).getMembershipFee();
        }

        System.out.println(total);

    }
}

