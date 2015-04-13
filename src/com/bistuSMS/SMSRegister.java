package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ZHRMoe on 15/4/14.
 */

public class SMSRegister extends JFrame{

    private JTextField nameTextField = new JTextField(13);
    private JPasswordField pswField = new JPasswordField(13);
    private JPasswordField confirmPswField = new JPasswordField(13);
    private JLabel titleLabel = new JLabel("注册新用户");
    private JLabel userNameLabel = new JLabel("用户名：    ");
    private JLabel pswLabel = new JLabel("密码：       ");
    private JLabel confirmPswLabel = new JLabel("确认密码：");
    private JButton registerBtn = new JButton("注册");
    private JButton backBtn = new JButton("返回");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();

    public SMSRegister() {

        this.setLayout(new GridLayout(5, 1));

        panel1.add(titleLabel);

        panel2.add(userNameLabel);
        panel2.add(nameTextField);

        panel3.add(pswLabel);
        panel3.add(pswField);

        panel4.add(confirmPswLabel);
        panel4.add(confirmPswField);

        panel5.add(backBtn);
        panel5.add(registerBtn);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-注册新用户");

    }

}
