package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
 */

/**
 * SMSUser is a class to describe a single user to SMS.
 * There are 2 properties in this class.
 * This class provides 2 construction methods.
 * This class provides 2 get/set methods.
 * ZHRMoe Studio, 2015.
 */

public class SMSUser {

    private String userName;
    private String userPsw;

    public SMSUser() {
        this.userName = "test";
        this.userPsw = "test";
    }

    public SMSUser(String userName, String userPsw) {
        this.userName = userName;
        this.userPsw = userPsw;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserPsw() {
        return this.userPsw;
    }

    public void setUserPsw(String psw) {
        this.userPsw = psw;
    }
}


