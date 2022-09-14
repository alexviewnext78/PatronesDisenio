package com.company.structural.decorator;

/**
 * Created by albertopalomarrobledo on 3/8/19.
 * Es un concreteComponent
 */
public class Black implements Credit {
    @Override
    public void showCredit() {
        System.out.println("El crédito es de 1.000.000");
    }
}
