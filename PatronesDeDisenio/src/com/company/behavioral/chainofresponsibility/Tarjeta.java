package com.company.behavioral.chainofresponsibility;

/**
 * Created by albertopalomarrobledo on 30/7/19.
 */
public class Tarjeta implements ApproveLoanChain {

    private ApproveLoanChain next;

    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void crediCardRequest(int totalLoan) {
    	//Inicializamos en campo next de Tarjeta a Gold
        Gold gold = new Gold();
        this.setNext(gold);

        //Asignamos en la tarjeta Gold el campo next a Platinum
        Platinium platinium = new Platinium();
        gold.setNext(platinium);

        //Asignamos en la tarjeta Platinum el campo next a Black
        Black black = new Black();
        platinium.setNext(black);

        //Llamamos al método Gold.crediCardRequest(totalLoan)
        next.crediCardRequest(totalLoan);
    }
}
