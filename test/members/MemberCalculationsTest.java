package members;

import accounting.Membership;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@author Sonja W
class MemberCalculationsTest {

    @Test
    void calculateAgeGroup() {
        //arrange
        MemberCalculations memberCalculations = new MemberCalculations();

        //act
        String junior = memberCalculations.calculateAgeGroup(17);
        String junior2 = memberCalculations.calculateAgeGroup(8);
        String senior = memberCalculations.calculateAgeGroup(45);
        String senior2 = memberCalculations.calculateAgeGroup(18);

        //assert
        assertEquals ("junior", junior);
        assertEquals ("junior", junior2);
        assertEquals ("senior", senior);
        assertEquals ("senior", senior2);
    }
    @Test
    void calculateMembershipFee() {
        //arrange
        Membership.importPriceList();
        MemberCalculations memberCalculations = new MemberCalculations();

        //act
        double passiveFee = memberCalculations.calculateMembershipFee("passivt", 14, "junior");
        double juniorFee = memberCalculations.calculateMembershipFee("junior", 14, "junior");
        double seniorFee = memberCalculations.calculateMembershipFee("senior", 32, "senior");
        double seniorOver60Fee = memberCalculations.calculateMembershipFee("senior", 61, "senior");

        //assert
        assertEquals(500, passiveFee);
        assertEquals(1000, juniorFee);
        assertEquals(1600, seniorFee);
        assertEquals(1200, seniorOver60Fee);
    }
}