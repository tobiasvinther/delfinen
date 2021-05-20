package accounting;

import members.*;

public class Subscription {

    //Det her skal være en metode hvor der bliver kaldt på arrayListen med medlemmere, så de enkeltes medlemmers kontingent
    //bliver lagt sammen og udregnet
    public static void calculateSubscription() {

        double total = 0;
        for (int i = 0; i < MemberList.getMemberArrayList().size(); i++ ) {
            total = total + MemberList.getMemberArrayList().get(i).getMembershipFee();
        }

        System.out.println(total);

    }
}

