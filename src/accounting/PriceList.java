package accounting;

public class PriceList {

    //todo: create this as an object instead
    private static double passiveFee = 500;
    private static double juniorFee = 1000;
    private static double seniorFee = 1600;
    private static double over60Discount = 0.75;
    private static double over60Fee = 1600 * over60Discount;

    public double getPassiveFee() {

        return passiveFee;
    }

    public double getJuniorFee() {

        return juniorFee;
    }

    public double getSeniorFee() {

        return seniorFee;
    }

    public double getOver60Fee() {

        return over60Fee;
    }

    public double getOver60Discount() {

        return over60Discount;
    }

}
