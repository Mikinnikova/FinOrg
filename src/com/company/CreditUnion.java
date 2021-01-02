package com.company;

public class CreditUnion extends FinacialOrganization implements Credits{
    private double maxSumICanTake = 100000.0;
    private double persentPerYear = 0.2;
    public CreditUnion(String name, String address) {
        super(name, address);
    }

    @Override
    public double howMuchINeedToGiveBack(double sum) {
        if(sum > maxSumICanTake|| sum<0) {return 0;}
        return (sum*persentPerYear) + sum;
    }

    public  double getMaxSumICanTake() {
        return maxSumICanTake;
    }

    public  double getPersentPerYear() {
        return persentPerYear;
    }
}
