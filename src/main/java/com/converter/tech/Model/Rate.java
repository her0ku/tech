package com.converter.tech.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rates")
public class Rate {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;
    @Column
    private LocalDate localDate;
    @Column
    private String charCode;
    @Column
    private double currentRate;

    public Rate() {
    }

    public Rate(String id, LocalDate localDate, String charCode, double currentRate) {
        this.id = id;
        this.localDate = localDate;
        this.charCode = charCode;
        this.currentRate = currentRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id='" + id + '\'' +
                ", localDate=" + localDate +
                ", charCode='" + charCode + '\'' +
                ", currentRate=" + currentRate +
                '}';
    }
}
