package com.company.structural.bridge;

/**
 * Created by albertopalomarrobledo on 2/8/19.
 */
public abstract class AbstractCreditCard {

    protected ICreditCard tarjeta;

    protected AbstractCreditCard(ICreditCard tarjeta){
        this.tarjeta = tarjeta;
    }

    public abstract void realizarPago();
}
