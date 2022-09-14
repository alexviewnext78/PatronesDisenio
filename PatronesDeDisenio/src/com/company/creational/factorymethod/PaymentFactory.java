package com.company.creational.factorymethod;

/**
 * Created by albertopalomarrobledo on 15/7/19.
 * Este es el creator
 */
public class PaymentFactory {

    public static Payment buildPayment(TypePayment typePayment){
    	//Se desacopla la forma en la creación de los objetos
        switch (typePayment){
            case GOOGLEPAY:
                return new GooglePayment();
            case CARD:
                return new CardPayment();
            default:
                return new CardPayment();
        }
    }
}
