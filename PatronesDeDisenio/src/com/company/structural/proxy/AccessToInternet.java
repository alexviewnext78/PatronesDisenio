package com.company.structural.proxy;

/**
 * Created by albertopalomarrobledo on 4/8/19.
 * Este es el RealSubject
 */
public class AccessToInternet implements Internet {

    @Override
    public void connectTo(String url) throws Exception {
        System.out.println("Conectando a: " + url);
    }
}
