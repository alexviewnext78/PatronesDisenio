package com.company.structural.facade;

/**
 * Created by albertopalomarrobledo on 3/8/19.
 */
public class Gold implements Credit {

    @Override
    public void showCredit() {
        System.out.println("La tarjeta Gold tiene un Cr�dito de 200.000");
    }
}
