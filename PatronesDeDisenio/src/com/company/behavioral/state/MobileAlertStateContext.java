package com.company.behavioral.state;

/**
 * Created by albertopalomarrobledo on 31/7/19.
 */
public class MobileAlertStateContext {

    private MobileAlertState currentState;

    //Por defecto el estado es con sonido
    public MobileAlertStateContext(){
        currentState = new Sound();
    }

    public void setState(MobileAlertState state){
        currentState = state;
    }

    public void alert(){
        currentState.alert(this);
    }
}
