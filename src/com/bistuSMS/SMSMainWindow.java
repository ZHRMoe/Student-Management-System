package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasee on 2015/4/13.
 */
public class SMSMainWindow extends JFrame {

    private JLabel label = new JLabel("Login Succeed.");
    private JPanel panel = new JPanel();

    public SMSMainWindow() {

        this.setLayout(new GridLayout(1, 1));

        panel.add(label);
        this.add(panel);

        this.setSize(200, 100);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统提示");
    }
}
