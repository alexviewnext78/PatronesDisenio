package com.company.structural.flyweight;

/**
 * Created by albertopalomarrobledo on 4/8/19.
 */
public class Asesino implements Enemy {

    private String weapon;
    private final String LIFE;

    public Asesino(){
        LIFE = "200";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("El arma del asesino es: " + weapon);
    }

    @Override
    public void lifePoints() {
        System.out.println("La vida de un asesino son: " + LIFE);
    }
}
