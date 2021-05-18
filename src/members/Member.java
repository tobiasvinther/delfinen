package members;

import accounting.PriceList;
import java.text.DecimalFormat;

//@author Tobias Vinther
public class Member {

    private String name;
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
     * @param age  member age
     * @param membershipType active/passive
     * @param activityType exercise/competitive (empty if passive)
     */
    public Member (String name, int age, String membershipType, String activityType) {
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
        this.activityType = activityType;

        this.hasPaidMembership = true;
        this.ageGroup = calculateAgeGroup(age);
        this.membershipFee = calculateMembershipFee(membershipType, age);
        this.memberID = memberIDCounter;
        memberIDCounter++;
    }

    public String calculateAgeGroup (int age) {
        if(age < 18) {
            return "junior";
        } else {
            return "senior";
        }
    }

    //todo: change return values to get input from priceList
    public double calculateMembershipFee(String membershipType, int age) {
        PriceList priceList = new PriceList();

        if(membershipType.equals("passiv")) {
            return priceList.getPassiveFee(); //passive
        } else if(ageGroup.equals("junior")) {
            return priceList.getJuniorFee(); //junior
        } else if (ageGroup.equals("senior") && age > 60) {
            return priceList.getOver60Fee(); //senior with discount
        } else {
            return priceList.getSeniorFee(); //normal senior
        }
    }

    public void printMember() {

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("* " + name);
        System.out.println("* " + "Medlems-ID: " + memberID);
        System.out.println("* " + age + " år");
        System.out.println("* " + ageGroup.substring(0, 1).toUpperCase() + ageGroup.substring(1));
        System.out.println("* " + membershipType.substring(0, 1).toUpperCase() + membershipType.substring(1) + "t medlem");
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
        return name + ", " + age + ", " + ageGroup;
    }



}
