package com.countries.consumeapi.model;

import java.util.ArrayList;

public class Population {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public void addData(Data d){
        data.add(d);
    }
    public void removeData(Data d){
        data.remove(d);
    }
}
