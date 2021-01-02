package com.company;

public class Bank extends FinacialOrganization implements Exchange, Credits, Depozit, SendMoney{
    private double maxSumICanTake = 200000.0;
    private double persentPerYear = 0.25;

    private int yearOfLicenziaReciving;
    private double depozitProcent = 0.12;



    public Bank(String name, String address, int yearOfLicenziaReciving) {
        super(name, address);
        this.yearOfLicenziaReciving = yearOfLicenziaReciving;
    }

    @Override
    public double exchangeUahToUsd(double sum) {
        return sum/28.5;
    }

    @Override
    public double exchangeUahToEur(double sum) {
        return sum/34.5;
    }

    @Override
    public double exchangeUsdToUah(double sum) {
        return sum*28.2;
    }

    @Override
    public double exchangeEurToUah(double sum) {
        return sum*34.3;
    }

    @Override
    public double howMuchINeedToGiveBack(double sum) {
        if(sum > maxSumICanTake || sum<0) {return 0;}
        return (sum* persentPerYear) + sum;
    }

    @Override
    public double putMoney(double sumOfMoney, int suOfMonth) {
        if(suOfMonth>12)   return 0;
        return (((sumOfMoney * depozitProcent)/12)*suOfMonth)+sumOfMoney;
    }

    public  double getMaxSumICanTake() {
        return maxSumICanTake;
    }

    public double getPersentPerYear() {
        return persentPerYear;
    }
    public double getDepozitProcent() {
        return depozitProcent;
    }

    @Override
    public double sendMoney(double sum) {
        return (sum*0.01)+sum +5;
    }
}
