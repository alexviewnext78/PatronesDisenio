package com.company.behavioral.visitor;

/**
 * Created by albertopalomarrobledo on 2/8/19.
 */
public interface CreditCardVisitor {
	//Para cada tipo de visitante debemos implementar todos lo métodos declarados en esta interfaz
    void ofertaGasolina(OfertaGasolina ofertaGasolina);
    void ofertaVuelos(OfertaVuelos ofertaVuelos);
}
