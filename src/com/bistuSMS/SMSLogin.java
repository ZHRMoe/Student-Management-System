package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasee on 2015/4/12.
 */
public class SMSLogin extends JFrame{
    JLabel loginLabel = new JLabel("Login");
    public SMSLogin (){
        setLayout(new GridLayout());
        add(loginLabel);
    }
}
