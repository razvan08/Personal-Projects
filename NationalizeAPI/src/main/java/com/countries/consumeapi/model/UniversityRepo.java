package com.countries.consumeapi.model;

import java.util.List;

public class UniversityRepo {
    private List<University> universityList;

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public void addUniversity(University u){
        universityList.add(u);
    }

    public void removeUniversity(University u){
        universityList.remove(u);
    }
}
