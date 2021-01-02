package com.company;

public class Obmenka extends FinacialOrganization implements Exchange {

    public Obmenka(String name, String address) {
        super(name, address);
    }


    @Override
    public double exchangeUahToUsd(double sum) {
        return sum/28.3;
    }

    @Override
    public double exchangeUahToEur(double sum) {
        return sum/34.6;
    }

    @Override
    public double exchangeUsdToUah(double sum) {
        return sum*28.1;
    }

    @Override
    public double exchangeEurToUah(double sum) {
        return sum*34.1;
    }
}
