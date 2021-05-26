package Controller;

import accounting.Membership;
import accounting.Subscription;
import members.Member;
import members.MemberList;
import members.WriteToFile;

//@author Sonja W
public class Controller {

    //Create new member
    public void newMember(Member newMember) {
        MemberList.addMemberToList(newMember);
    }

    //Search for member
    public void searchMember(String name) {
        MemberList.searchForMember(name);
    }

    //See memberlist
    public void printMemberList() {
        MemberList.printMemberList();
    }

    //Print member
    public void printMember(int index) {
        MemberList.getMemberArrayList().get(index).printMember();
    }

    //Edit member
    public void editName(Member member, String newName) {
        member.setName(newName);
    }

    //Edit membershipType
    public void editMembershipType(Member member, String newMembershipType) {
        member.setMembershipType(newMembershipType);
    }

    //Edit activityType
    public void editActivityType(Member member, String newActivityType) {
        member.setActivityType(newActivityType);
    }

    //Edit email
    public void editEmail(Member member, String newEmail) {
        member.setEmail(newEmail);
    }

    //Delete member
    public void deleteMember(Member member) {
        MemberList.deleteMemberFromList(member);
    }


    //Edit passive membership
    public double getPassiveFee() {
        return Membership.getMembershipFee("Passivt"); }

    //Edit junior membership
    public double getJuniorFee() {
        return Membership.getMembershipFee("Junior"); }

    //Edit senior membership
    public double getSeniorFee() {
        return Membership.getMembershipFee("Senior"); }

    //Edit 60+ membership
    public double getOver60Fee() {
        return Membership.getMembershipFee("Senior over 60");
    }

    public void setMembershipFee(String membershipName, double newFee) {
        Membership.getMembership(membershipName).setFee(newFee);
    }

    public void setOver60Discount(double newDiscount) {
        Membership.setOver60discount(newDiscount);
    }

    public void printMemberships() {
        for(Membership membership : Membership.getFeeList()) {
            System.out.println(membership);
        }
    }

    public void exportMemberListToFile() {
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.writeMembersToFile();
    }

    public void calculateYearlyIncome() {
        Subscription.calculateSubscription();
    }

    public void seeMembersInArrears() {
        Subscription.hasNotPayed();
    }

    //Edit 60+ membership discount
    //public double getOver60Discount() {
      //  return Membership.getMembershipFee("Senior rabat"); }


}
