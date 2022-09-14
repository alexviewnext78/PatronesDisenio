package com.company.behavioral.visitor;

/**
 * Created by albertopalomarrobledo on 2/8/19.
 */
public class ClassicCreditCardVisitor implements CreditCardVisitor{

    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        System.out.println("Descuento del 3% en gasolina con tu tarjeta Clasica");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        System.out.println("Descuento del 5% en Vuelos con tu tarjeta Clasica");
    }
}
