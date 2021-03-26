package com.converter.tech.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column
    private String numCode;
    @Column
    private String charNode;
    @Column
    private int nominal;
    @Column
    private String name;

    public Currency() {
    }

    public Currency(String id, String numCode, String charNode, int nominal, String name) {
        this.id = id;
        this.numCode = numCode;
        this.charNode = charNode;
        this.nominal = nominal;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharNode() {
        return charNode;
    }

    public void setCharNode(String charNode) {
        this.charNode = charNode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                id + '\'' +
                numCode + '\'' +
                charNode + '\'' +
                nominal +
                name + '\'';
    }
}
