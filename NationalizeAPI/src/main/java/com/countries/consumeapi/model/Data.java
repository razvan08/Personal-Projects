package com.countries.consumeapi.model;

public class Data {
    private String id_nation;
    private String nation;
    private int id_year;
    private long population;
    private String slug_nation;

    public String getId_nation() {
        return id_nation;
    }

    public void setId_nation(String id_nation) {
        this.id_nation = id_nation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getId_year() {
        return id_year;
    }

    public void setId_year(int id_year) {
        this.id_year = id_year;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getSlug_nation() {
        return slug_nation;
    }

    public void setSlug_nation(String slug_nation) {
        this.slug_nation = slug_nation;
    }
}
