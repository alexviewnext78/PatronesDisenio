package com.company.behavioral.visitor;

/**
 * Created by albertopalomarrobledo on 2/8/19.
 */
public interface OfertaElement {
	//Interfaz que declara la operación de aceptación. Es el punto de entrada que permite a un objeto 
	//ser visitado por el objeto visitor
    void accept(CreditCardVisitor visitor);
}
