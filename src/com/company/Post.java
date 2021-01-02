package com.company;

public class Post extends FinacialOrganization implements SendMoney{


    public Post(String name, String address) {
        super(name, address);
    }

    @Override
    public double sendMoney(double sum) {
        return (sum * 0.02) + sum;
    }
}
