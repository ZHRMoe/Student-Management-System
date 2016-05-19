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
        userList.add(user);
    }

    public void forgotPsw(int position, SMSUser user) {
        userList.remove(position);
        userList.add(user);
    }

    public SMSUser getUser(int position) {
        return userList.get(position);
    }

    public int getUserListCount() {
        return userList.size();
    }

}
