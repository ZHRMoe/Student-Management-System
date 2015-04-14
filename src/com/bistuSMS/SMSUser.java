package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
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


