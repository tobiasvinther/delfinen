package accounting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriceList {

    //todo: change these to read from file
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

    /*
    public void initializePriceList() throws FileNotFoundException {
        File priceList = new File("resources/memberships.csv"); //create a reference to the csv file
        Scanner fileScanner = new Scanner(priceList); //

        fileScanner.nextLine(); //this lets up ignore the first line of the CSV

        double[] feeArray = new double[4];
        //while there is something left to read, continue

        while(fileScanner.hasNext()) {

            String currentString = fileScanner.nextLine(); //string that holds the current String. We read the file line by line.
            String[] lineAsArray = currentString.split(";"); //split currentString using ";" as separator indicator

            for(int i = 0; i<4; i++) {
                fileScanner.nextLine();
                feeArray[i] = fileScanner.nextInt();
            }

        }
        passiveFee = feeArray[0];
        juniorFee = feeArray[1];
        seniorFee = feeArray[2];
        over60Fee = feeArray[3] * over60Discount;
        System.out.println(passiveFee + " " + juniorFee + " " + seniorFee + " " + over60Fee); //test
    }

    public static int tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

     */
}
