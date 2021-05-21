package com.countries.consumeapi.model;

public class Person {
    private String name;
    private Country c1;
    private Country c2;
    private Country c3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getC1() {
        return c1;
    }

    public void setC1(Country c1) {
        this.c1 = c1;
    }

    public Country getC2() {
        return c2;
    }

    public void setC2(Country c2) {
        this.c2 = c2;
    }

    public Country getC3() {
        return c3;
    }

    public void setC3(Country c3) {
        this.c3 = c3;
    }
}
