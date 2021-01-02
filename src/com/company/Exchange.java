package com.company;

public interface Exchange {
    double exchangeUahToUsd(double sum);
    double exchangeUahToEur(double sum);
    double exchangeUsdToUah(double sum);
    double exchangeEurToUah(double sum);
}
