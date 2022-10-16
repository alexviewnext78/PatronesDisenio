package com.company.structural.decorator;

/**
 * Created by albertopalomarrobledo on 3/8/19.
 * Es un ConcreteDecorator
 */
public class SecurePaymentDecorator extends CreditDecorator {


    public SecurePaymentDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }

    @Override
    public void showCredit() {
        decoratedCredit.showCredit();
        configSecurePayment();
    }

    private void configSecurePayment(){
        System.out.println("La tarjeta ha sido configurada con Seguridad Máxima de pago");
    }
}
