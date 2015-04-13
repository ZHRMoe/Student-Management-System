package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasee on 2015/4/12.
 */

public class SMSLogin extends JFrame{

    private JTextField nameTextField;
    private JPasswordField pswField;
    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel pswLabel;
    private JButton logInBtn;
    private JButton registerBtn;
    private JButton forgotPswBtn;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public SMSLogin() {
        nameTextField = new JTextField(13);
        pswField = new JPasswordField(13);
        titleLabel = new JLabel("学生管理系统");
        userNameLabel = new JLabel("用户名：");
        pswLabel = new JLabel("密码：   ");
        logInBtn = new JButton("登陆");
        registerBtn = new JButton("注册");
        forgotPswBtn = new JButton("忘记密码");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        this.setLayout(new GridLayout(4, 1));

        panel1.add(titleLabel);

        panel2.add(userNameLabel);
        panel2.add(nameTextField);

        panel3.add(pswLabel);
        panel3.add(pswField);

        panel4.add(registerBtn);
        panel4.add(forgotPswBtn);
        panel4.add(logInBtn);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-登陆");

    }
    
}
