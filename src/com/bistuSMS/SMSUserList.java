package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/13.
 */

/**
 * SMSUserList is a class to describe a group of users, based on ArrayList(java.util.*).
 * There is only one ArrayList property named userList in this class.
 * This class provides only one construction method without parametric.
 * This class provides 2 methods to manage the list:
 'register' is a method to register a new user, if the username has not been used, the method will return true, else return false.
 'forgotPsw' is a method to change a user's password, firstly check whether the username does exist, if yes,change the password and return yes, else return false.
 * ZHRMoe Studio, 2015.
 */

public class SMSUserList {

    public ArrayList<SMSUser> userList = new ArrayList<SMSUser>();

    public SMSUserList() {
        SMSUser testUser = new SMSUser();
        userList.add(testUser);
    }

    public boolean register(SMSUser user) {
        for (int i = 0; i < userList.size(); ++i) {
            if (user.getUserName().equals(userList.get(i).getUserName())) {
                userList.add(user);
                return true;
            }
        }
        return false;
    }

    public boolean forgotPsw(SMSUser user) {
        for (int i = 0; i < userList.size(); ++i) {
            if (user.getUserName().equals(userList.get(i).getUserName())) {
                userList.remove(i);
                userList.add(i, user);
                return true;
            }
        }
        return false;
    }

    public SMSUser getUser(int position) {
        return userList.get(position);
    }

    public int getUserListCount() {
        return userList.size();
    }
}
