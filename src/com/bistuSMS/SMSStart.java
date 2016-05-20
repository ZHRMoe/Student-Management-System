package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/14.
 */
public class SMSStart {

    public static SMSUserList userList = SMSXML.getUsers();

    public static SMSUserList getUserList() {
        return userList;
    }

    public static void main(String[] args) {
        new SMSWelcomeWindow();
    }

}
