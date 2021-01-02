package com.company;

public class Piph extends FinacialOrganization implements Depozit {
    private int year;
    private double depozitProcent = 0.1;

    public Piph(String name, String address, int year) {
        super(name, address);
        this.year = year;
    }

    @Override
    public double putMoney(double sumOfMoney, int suOfMonth) {
        if(suOfMonth<12)   return 0;
        return (((sumOfMoney * depozitProcent)/12)*suOfMonth)+sumOfMoney;
    }

    public double getDepozitProcent() {
        return depozitProcent;
    }
}
