package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ZHRMoe on 15/4/14.
 */

public class SMSForgetPsw extends JFrame {

    private JTextField nameTextField;
    private JPasswordField pswField;
    private JPasswordField confirmPswField;
    private JLabel titleLabel;
    private JLabel userNameLabel;
    private JLabel pswLabel;
    private JLabel confirmPswLabel;
    private JButton changePswBtn;
    private JButton backBtn;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;

    public SMSForgetPsw() {
        nameTextField = new JTextField(13);
        pswField = new JPasswordField(13);
        confirmPswField = new JPasswordField(13);
        titleLabel = new JLabel("忘记密码");
        userNameLabel = new JLabel("用户名：    ");
        pswLabel = new JLabel("密码：       ");
        confirmPswLabel = new JLabel("确认密码：");
        backBtn = new JButton("返回");
        changePswBtn = new JButton("修改密码");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();

        this.setLayout(new GridLayout(5, 1));

        panel1.add(titleLabel);

        panel2.add(userNameLabel);
        panel2.add(nameTextField);

        panel3.add(pswLabel);
        panel3.add(pswField);

        panel4.add(confirmPswLabel);
        panel4.add(confirmPswField);

        panel5.add(backBtn);
        panel5.add(changePswBtn);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-忘记密码");

    }

    public static void main(String[] args) {
        new SMSForgetPsw();
    }
}
