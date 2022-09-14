package com.company.behavioral.command;

/**
 * Created by albertopalomarrobledo on 30/7/19.
 */
public class CreditCardDesactivateCommand implements Command {

    CreditCard creditCard;
    public CreditCardDesactivateCommand(CreditCard creditCard){
        this.creditCard = creditCard;
    }

    @Override
    public void execute() {
    	//Hace que nuestro código sea extendible
        creditCard.desactivate();
        creditCard.sendSMSToCustomerDesactivate();
    }
}
