/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wladmir.conversor.model;

/**
 *
 * @author Wladmir Rodrigues
 */
public class Moeda {
    private String name;
    private String code;
    private String codeIn;

     public Moeda( String name, String code, String codeIn, double bid) {
        this.name = name;
        this.code = code;
        this.codeIn = codeIn;
        this.bid = bid;
    }
    
    @Override
    public String toString() {
        return "Moeda{" + "name=" + name + ", code=" + code + ", codeIn=" + codeIn + ", bid=" + bid + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeIn() {
        return codeIn;
    }

    public void setCodeIn(String codeIn) {
        this.codeIn = codeIn;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
    private double bid;

   
    
}
