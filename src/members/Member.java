package members;

//@author Tobias Vinther
public class Member {

    private String name;
    private int age;
    private int memberID;
    private String membershipType; //active or passive
    private String ageGroup; //junior or senior
    private String activityType; //exercise or competitive
    private double membershipFee;
    //private ArrayList<Competition> competitionResultList

    private static int memberIDCounter = 1; //todo: perhaps change to more unique ID generation?

    public Member (String name, int age, String membershipType, String activityType) {
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
        this.activityType = activityType;

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
        if(membershipType.equals("passive")) {
            return 500; //passive
        } else if(ageGroup.equals("junior")) {
            return 1000; //junior
        } else if (ageGroup.equals("senior") && age > 60) {
            return 1600 * 0.75; //senior with discount
        } else {
            return 1000; //normal senior
        }
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + ageGroup;
    }

}
