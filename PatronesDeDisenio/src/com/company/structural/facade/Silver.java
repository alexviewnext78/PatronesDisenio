package com.company.structural.facade;

/**
 * Created by albertopalomarrobledo on 3/8/19.
 */
public class Silver implements Credit {

    @Override
    public void showCredit() {
        System.out.println("La tarjeta Silver tiene un Cr?dito de 5.000");
    }
}
