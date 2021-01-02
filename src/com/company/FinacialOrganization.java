package com.company;

public abstract class FinacialOrganization {
    private String name;
    private String address;

    public FinacialOrganization(String name, String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }

    public String getClassName(){
        return getClass().getSimpleName();
    }

}
