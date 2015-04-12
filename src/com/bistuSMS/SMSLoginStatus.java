package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
 */

/**
 * Login is a class for login action.
 * There are 3 properties in the class: 'userName', 'loginSucceed', 'logined'(default as false).Get method to boolean type properties are provided.
 * ZHRMoe Studio, 2015.
 */

public class SMSLoginStatus {

    private String userName;
    private boolean loginSucceed = false;
    private boolean logined;

    public SMSLoginStatus() {
        this.loginSucceed = false;
        this.logined = false;
    }

    public boolean isLoginSucceed() {
        return loginSucceed;
    }

    public boolean isLogined() {
        return logined;
    }

}
