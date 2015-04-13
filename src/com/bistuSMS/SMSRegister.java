package com.bistuSMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ZHRMoe on 15/4/14.
 */

public class SMSRegister extends JFrame implements ActionListener{

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

        backBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-注册新用户");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == registerBtn) {
            String userName = nameTextField.getText();
            char[] passWord = pswField.getPassword();
            char[] confirmPsw = confirmPswField.getPassword();
            String psw = String.valueOf(passWord);
            String conPsw = String.valueOf(confirmPsw);
            SMSUserList userList = new SMSUserList();
            boolean registerFlag = true;
            if (psw.equals(conPsw)) {
                for (int i = 0; i < userList.getUserListCount(); ++i) {
                    if (userList.getUser(i).getUserName().equals(userName)) {
                        registerFlag = false;
                        JOptionPane.showMessageDialog(null, "用户名已存在！");
                    }
                }
                if (registerFlag) {
                    SMSUser newUser = new SMSUser(userName, psw);
                    userList.register(newUser);
                    new SMSLogin();
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "两次输入的密码不同！");
            }
        } else if (a.getSource() == backBtn) {
            new SMSLogin();
            this.setVisible(false);
        }
    }

}
