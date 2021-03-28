package com.converter.tech.Model;

public class Buffer {
    private String charCode;
    private String name;
    private double currentRate;
    private int nominal;

    public Buffer() {
    }

    public Buffer(String charCode, String name, double currentRate, int nominal) {
        this.charCode = charCode;
        this.name = name;
        this.currentRate = currentRate;
        this.nominal = nominal;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "charCode='" + charCode + '\'' +
                ", name='" + name + '\'' +
                ", currentRate=" + currentRate +
                ", nominal=" + nominal +
                '}';
    }
}
