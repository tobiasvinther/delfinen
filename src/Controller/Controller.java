package Controller;

import accounting.Membership;
import accounting.PriceList;
import members.Member;
import members.MemberList;
import java.time.LocalDate;

public class Controller {
    Member member = new Member();
    MemberList memberList = new MemberList();
    PriceList priceList = new PriceList();

    //Create new member
    public Member newMember = new Member(String name, String birthday, String email, String membershipType, String activityType) {
        Member newMember = new Member(name, birthday, email, membershipType, activityType);
        return newMember;
    }

    //Search for member
    public void searchMember() {memberList.searchForMember();
    }

    //See memberlist
    public void getMemberArraylist() {memberList.printMemberList();
    }

    //Edit member

    //Delete member

    //Edit passive membership
    public void getPassivFee() {priceList.getPassiveFee(); }

    //Edit junior membership
    public void getJuniorFee() {priceList.getJuniorFee();}

    //Edit senior membership
    public void getSeniorFee() {priceList.getSeniorFee(); }

    //Edit 60+ membership
    public void getOver60Fee() {priceList.getOver60Fee(); }

    //Edit 60+ membership discount
    public void getOver60Discount() {priceList.getOver60Discount(); }

}
