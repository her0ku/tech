package com.converter.tech.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String rateFrom;
    private String rateTo;
    private double baseSum;
    private double currentSum;
    private LocalDate localDate;

    public History() {
    }

    public History(String rateFrom, String rateTo, double baseSum, double currentSum, LocalDate localDate) {
        this.rateFrom = rateFrom;
        this.rateTo = rateTo;
        this.baseSum = baseSum;
        this.currentSum = currentSum;
        this.localDate = localDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRateFrom() {
        return rateFrom;
    }

    public void setRateFrom(String rateFrom) {
        this.rateFrom = rateFrom;
    }

    public String getRateTo() {
        return rateTo;
    }

    public void setRateTo(String rateTo) {
        this.rateTo = rateTo;
    }

    public double getBaseSum() {
        return baseSum;
    }

    public void setBaseSum(double baseSum) {
        this.baseSum = baseSum;
    }

    public double getCurrentSum() {
        return currentSum;
    }

    public void setCurrentSum(double currentSum) {
        this.currentSum = currentSum;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "History{" +
                "rateFrom='" + rateFrom + '\'' +
                ", rateTo='" + rateTo + '\'' +
                ", baseSum='" + baseSum + '\'' +
                ", currentSum='" + currentSum + '\'' +
                '}';
    }
}
