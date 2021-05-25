package members;

import accounting.Membership;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

//@author Tobias Vinther
public class MemberCalculations {

    public String calculateAgeGroup (int age) {
        if(age < 18) {
            return "junior";
        } else {
            return "senior";
        }
    }

    public String calculateMembershipType(int age, boolean isPassive) {
        if(isPassive) {
            return "passiv";
        } else {
            return calculateAgeGroup(age);
        }
    }

    public double calculateMembershipFee(String membershipType, int age, String ageGroup) {
        if(membershipType.equals("passiv") || membershipType.equals("passivt")) {
            return Membership.getMembershipFee("passivt"); //passive
        } else if(ageGroup.equals("junior")) {
            return Membership.getMembershipFee("junior"); //junior
        } else if (ageGroup.equals("senior") && age > 60) {
            return Membership.getMembershipFee("senior over 60"); //senior with discount
        } else {
            return Membership.getMembershipFee("senior"); //normal senior
        }
    }

    //calculate age based on birth date and current date
    public int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    //convert birthdate as String to LocalDate
    public LocalDate convertStringToLocalDate(String birthDateAsString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(birthDateAsString, formatter);
    }

    //check email validity
    public boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

}
