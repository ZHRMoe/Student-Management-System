package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/12.
 */

/**
 * Login is a class for login action.
 * There are 4 properties in the class: 'userName', 'passWord', 'loginSucceed', 'logined'(default as false).Get method to boolean type properties are provided.
 * A method named 'loginAction': if username and password is correct, 'loginSucceed' and 'logined' become true.
 * ZHRMoe Studio, 2015.
 */

public class Login {

    private String userName;
    private String passWord;
    private boolean loginSucceed = false;
    private boolean logined;

    public Login() {
        this.userName = "test001";
        this.passWord = "test001";
        this.logined = false;
    }

    public boolean isLoginSucceed() {
        return loginSucceed;
    }

    public boolean isLogined() {
        return logined;
    }

    public void loginAction(String userName, String passWord) {
        if (userName.equals(this.userName) && passWord.equals(this.passWord)) {
            loginSucceed = true;
            logined = true;
        }
    }
}
