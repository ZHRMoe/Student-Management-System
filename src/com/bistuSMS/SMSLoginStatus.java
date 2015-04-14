package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
 */

/**
 * SMSLoginStatus is a class to describe login status.
 * There are 3 properties in this class.
 * This class provides only one construction method without parametric.(In default situation, the boolean properties are false.)
 * This class provides 2 methods:
 'isLoginSucceed' is a method to know the username and password is correct.
 'islogedIn' is a method to open main window.
 * ZHRMoe Studio, 2015.
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
