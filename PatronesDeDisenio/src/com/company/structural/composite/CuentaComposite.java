package com.company.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 3/8/19.
 * Ser� el Composite, define el comportamiento de los componentes que tienen los hijos
 */
public class CuentaComposite implements CuentaComponent {

    private List<CuentaComponent> childCuentas;

    public CuentaComposite(){
        this.childCuentas = new ArrayList<>();
    }

    @Override
    public void showAccountName() {
        for(CuentaComponent cuenta : childCuentas){
            cuenta.showAccountName();
        }
    }

    @Override
    public Double getAmount() {
        Double totalAmount = 0.0;
        for (CuentaComponent cuenta : childCuentas){
            totalAmount += cuenta.getAmount();
        }
        System.out.print("La cantidad de dinero es: " + totalAmount);
        return totalAmount;
    }

    public void addCuenta(CuentaComponent cuenta){
        childCuentas.add(cuenta);
    }

    public void removeCuenta(CuentaComponent cuenta){
        childCuentas.remove(cuenta);
    }
}
