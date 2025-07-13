package com.example.country;

public class Country {
    private String code;
    private String name;
    private String capital;
    private int population;

    public Country() {}

    public Country(String code, String name, String capital, int population) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
}
