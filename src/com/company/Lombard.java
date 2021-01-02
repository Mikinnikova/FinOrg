package com.company;

public class Lombard extends FinacialOrganization implements Credits {

    private double maxSumICanTake = 50000.0;
    private double depozitProcent = 0.4;

    public Lombard(String name, String address) {
        super(name, address);
    }

    @Override
    public double howMuchINeedToGiveBack(double sum) {
        if(sum > maxSumICanTake || sum<0) {return 0;}
        return (sum*depozitProcent) + sum;
    }

    public  double getMaxSumICanTake() {
        return maxSumICanTake;
    }

    public  double getPersentPerYear() {
        return depozitProcent;
    }
}
