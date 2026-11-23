/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui_assign;

/**
 *
 * @author USER
 */
public class Bike {
   


    private String type;
    private double pricePerHour;
    private boolean available;

    public Bike(String type, double pricePerHour, boolean available) {
        this.type = type;
        this.pricePerHour = pricePerHour;
        this.available = available;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }
}
    

