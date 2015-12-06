package com.bjorn.controller;

/**
 * Created by Björn on 2015-12-05.
 */
public class StockDto {

    private String name;
    private String shortName;

    public StockDto(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
