package members;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

//@author Tobias Vinther
public class Member {

    private String name;
    private LocalDate birthday;
    private int age;
    private int memberID;
    private String membershipType; //active or passive
    private String ageGroup; //junior or senior
    private String activityType; //exercise or competitive
    private double membershipFee;
    private boolean hasPaidMembership;
    //private ArrayList<Competition> competitionResultList

    private static int memberIDCounter = 1; //todo: perhaps change to more unique ID generation?

    /**
     * @param name first and last name
     * @param birthday  year, month, date
     * @param membershipType active/passive
     * @param activityType exercise/competitive (empty if passive)
     */
    public Member (String name, LocalDate birthday, String membershipType, String activityType) {
        this.name = name;
        this.birthday = birthday;
        this.membershipType = membershipType;
        this.activityType = activityType;
        this.hasPaidMembership = true;
        MemberCalculations memCalculator = new MemberCalculations();
        this.age = memCalculator.calculateAge(birthday);
        this.ageGroup = memCalculator.calculateAgeGroup(age);
        this.membershipFee = memCalculator.calculateMembershipFee(membershipType, age, ageGroup);
        this.memberID = memberIDCounter;

        memberIDCounter++;

        MemberList.addMemberToList(this);
    }

    /**
     * @param name first and last name
     * @param birthday  DD/MM/YYYY
     * @param membershipType active/passive
     * @param activityType exercise/competitive (empty if passive)
     */
    //overloaded constructor, where birthday parameter is a string instead
    public Member (String name, String birthday, String membershipType, String activityType) {
        MemberCalculations memCalculator = new MemberCalculations();
        this.name = name;
        this.birthday = memCalculator.convertStringToLocalDate(birthday);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
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
}
