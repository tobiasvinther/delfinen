package accounting;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//@author Tobias Vinther
public class Membership {

    private String name;
    private double fee;
    private static final ArrayList<Membership> FEE_LIST = new ArrayList<>();

    public Membership(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    public static void importPriceList() {

        File priceList = new File("resources/memberships.csv");

        try {
            Scanner fileReader = new Scanner(priceList);
            fileReader.nextLine();

            while(fileReader.hasNext()) {
                String currentString = fileReader.nextLine(); // a string that holds the current String.
                String[] lineAsArray = currentString.split(";"); //split currentString using ";" as separator indicator

                String name = lineAsArray[0];
                double fee = Double.parseDouble(lineAsArray[1]);

                Membership newMembership = new Membership(name, fee);
                FEE_LIST.add(newMembership);
            }

            //create an object for the senior over 60, based on the existing senior object
            for(Membership membership : FEE_LIST) {
                if(membership.name.equalsIgnoreCase("Senior")) {
                    Membership seniorMembership = new Membership("Senior over 60", (membership.fee * 0.75));
                    FEE_LIST.add(seniorMembership);
                    break;
                }
            }

        } catch(FileNotFoundException exception) {
            System.out.println("Prislisten kunne ikke findes");
        }
        //test
        for(Membership membership : FEE_LIST) {
            System.out.println(membership);
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "* " + name + ": " + df.format(fee) + " kr.";
    }

    public String getName() {
        return name;
    }

    public double getFee() {
        return fee;
    }

}
