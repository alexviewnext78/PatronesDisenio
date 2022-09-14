	package com.company.creational.singlenton;

/**
 * Created by albertopalomarrobledo on 29/7/19.
 */
public class Card {

    private static Card INSTANCE;

    private String cardNumber;

    private Card(){

    }

    //Al ser sincronizado nos aseguramos que cada hilo trabaja en exclusión mutua
    public synchronized static Card getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Card();
        }
        return INSTANCE;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
