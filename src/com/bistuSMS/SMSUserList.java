package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/13.
 */


public class SMSUserList {

    public ArrayList<SMSUser> userList = new ArrayList<SMSUser>();

    public SMSUserList() {
//        SMSUser testUser = new SMSUser();
//        userList.add(testUser);
    }

    public void register(SMSUser user) {
        try {
            SMSXML.addUser(user);
            userList = SMSXML.getUsers().userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forgotPsw(int position, SMSUser user) {
        try {
            SMSXML.removeUser(userList.get(position));
            SMSXML.addUser(user);
            userList = SMSXML.getUsers().userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SMSUser getUser(int position) {
        return userList.get(position);
    }

    public int getUserListCount() {
        return userList.size();
    }

}
