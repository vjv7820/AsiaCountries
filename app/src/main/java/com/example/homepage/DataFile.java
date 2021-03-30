package com.example.homepage;

import java.util.ArrayList;

public class DataFile {
    String name;
    String capital;
    String region;
    String subregion;
    long  popu;

    public DataFile(String name, String capital, String region, String subregion, long popu) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.popu = popu;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public long getPopu() {
        return popu;
    }



}
