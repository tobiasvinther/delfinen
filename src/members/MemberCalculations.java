package members;

import accounting.PriceList;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//@author Tobias Vinther
public class MemberCalculations {

    public String calculateAgeGroup (int age) {
        if(age < 18) {
            return "junior";
        } else {
            return "senior";
        }
    }

    public double calculateMembershipFee(String membershipType, int age, String ageGroup) {
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
        //return LocalDate.parse(birthDateAsString);
        return LocalDate.parse(birthDateAsString, formatter);
    }

}
