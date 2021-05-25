package members;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

//@author Tobias Vinther
public class Member implements Comparable<Member> {

    private String name;
    private LocalDate birthday;
    private int age;
    private int memberID;
    private String email;
    private String membershipType; //active or passive
    private String ageGroup; //junior or senior
    private String activityType; //exercise or competitive
    private double membershipFee;
    private boolean hasPaidMembership;
    //private ArrayList<Competition> competitionResultList

    private static int memberIDCounter = 1; //todo: perhaps change to more unique ID generation?

    /**
     * @param name first and last name
     * @param birthday  DD/MM/YYYY
     * @param membershipType active/passive
     * @param activityType exercise/competitive (empty if passive)
     */
    //constructor, where birthday parameter is a string instead
    public Member (String name, String birthday, String email, String membershipType, String activityType) {
        MemberCalculations memCalculator = new MemberCalculations();
        this.name = name;
        this.birthday = memCalculator.convertStringToLocalDate(birthday);
        this.email = email;
        this.membershipType = membershipType;
        this.activityType = activityType;
        this.hasPaidMembership = true;
        this.age = memCalculator.calculateAge(this.birthday);
        this.ageGroup = memCalculator.calculateAgeGroup(age);
        this.membershipFee = memCalculator.calculateMembershipFee(membershipType, age, ageGroup);
        this.memberID = memberIDCounter;

        memberIDCounter++;

        MemberList.addMemberToList(this);
    }

    public void printMember() {

        //this is to get rid of a single zero decimal and limit decimals to two places
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("-----------------------");
        System.out.println("* " + name);
        System.out.println("* " + "Medlems-ID: " + memberID);
        System.out.println("* " + "email: " + email);
        //formatting date to Danish standard
        System.out.println("* " + "Født: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(birthday));
        System.out.println("* " + age + " år");
        System.out.println("* " + ageGroup.substring(0, 1).toUpperCase() + ageGroup.substring(1));
        System.out.println("* " + membershipType.substring(0, 1).toUpperCase() + membershipType.substring(1) + "t medlem");
        //only display activityType if member is not passive
        if(!membershipType.equals("passiv")) {
            System.out.println("* " + activityType.substring(0, 1).toUpperCase() + activityType.substring(1));
        }
        System.out.println("* " + "Kontingent: " + df.format(membershipFee) + " kr. pro anno");
        System.out.print("* " + "Medlemsskab betalt: ");
        if(hasPaidMembership) {
            System.out.println("ja");
        } else {
            System.out.println("nej");
        }
    }

    @Override
    public String toString() {
        return name + ", " + ageGroup;
    }

    public int compareTo(Member otherMember) {
        if(this.ageGroup.equals(otherMember.ageGroup)) {
            //if both members are same agrGroup, compare membership fees (this will put passives at the bottom)
            return (int)this.membershipFee - (int)otherMember.membershipFee;
            //return 0;
        } else if(this.ageGroup.equals("senior") && otherMember.ageGroup.equals("junior")) {
            return 1;
        } else return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return this.birthday;
    }

    public String getAgeGroup() {
        return this.ageGroup;
    }

    public String getMembershipType() {
        return membershipType;
    }

    //when setting membershipType we should also recalculate membership fee
    public void setMembershipType(String membershipType) {
        MemberCalculations memCalculator = new MemberCalculations();
        this.membershipType = membershipType;
        this.membershipFee = memCalculator.calculateMembershipFee(membershipType, this.age, this.ageGroup);
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public boolean isHasPaidMembership() {
        return hasPaidMembership;
    }

    public void setHasPaidMembership(boolean hasPaidMembership) {
        this.hasPaidMembership = hasPaidMembership;
    }

    public int getMemberID() {
        return memberID;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}