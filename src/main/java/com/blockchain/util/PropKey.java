package com.blockchain.util;

public enum PropKey {

    LOGIN_URL("login_url"),
    SIGNUP_URL("signup_url"),
    BROWSER("browser");


    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
