package org.io.DAOs;

public enum BusStatus {
    OnRoute("OnRoute"),
    Broken("Broken"),
    Available("Available");

    private String stringStatus;

    BusStatus(String stringStatus){
        this.stringStatus = stringStatus;
    }
}
