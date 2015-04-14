package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
 */

public class SMSLoginStatus {

    private String userName;
    private boolean loginSucceed = false;
    private boolean logedIn;

    public SMSLoginStatus() {
        this.loginSucceed = false;
        this.logedIn = false;
    }

    public boolean isLoginSucceed() {
        return loginSucceed;
    }

    public void setLoginSucceed(boolean b) {
        this.loginSucceed = b;
    }

    public boolean isLogedIn() {
        return logedIn;
    }

    public void setLogedIn(boolean b) {
        this.logedIn = b;
    }

}
