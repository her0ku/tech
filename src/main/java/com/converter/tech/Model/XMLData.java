package com.converter.tech.Model;


import java.util.List;


public class XMLData {
    private List<Currency> currencyList;
    private List<Rate> rateList;
    public XMLData(List<Currency> currencyList, List<Rate> rateList) {
        this.currencyList = currencyList;
        this.rateList = rateList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    @Override
    public String toString() {
        return "XMLData{" +
                "currencyList=" + currencyList +
                ", rateList=" + rateList +
                '}';
    }
}
