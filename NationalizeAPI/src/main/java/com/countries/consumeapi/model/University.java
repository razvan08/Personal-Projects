package com.countries.consumeapi.model;

import java.net.URL;

public class University {
    private String alpha_two_code;
    private String name;
    private URL web_pages;
    private String country;
    private String state_province;
    private URL dpomains;

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getWeb_pages() {
        return web_pages;
    }

    public void setWeb_pages(URL web_pages) {
        this.web_pages = web_pages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public URL getDpomains() {
        return dpomains;
    }

    public void setDpomains(URL dpomains) {
        this.dpomains = dpomains;
    }
}

