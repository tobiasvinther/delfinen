package accounting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PriceList {

    private static double passiveFee;
    private static double juniorFee;
    private static double seniorFee;
    private static double over60Fee;

    private static double over60Discount = 0.75; //todo: perhaps change to read from file? Or percentage?

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
