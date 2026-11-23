/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui_assign;

/**
 *
 * @author USER
 */
public class BicycleRental1 {
   

    private Bike bike;
    private int hours;

    public BicycleRental1(Bike bike, int hours) {
        this.bike = bike;
        this.hours = hours;
    }

    
    public double calculateTotalCost() {
        return bike.getPricePerHour() * hours;
    }

    public Bike getBike() {
        return bike;
    }

    public int getHours() {
        return hours;
    }
}

