package com.bistuSMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by hasee on 2015/4/12.
 */

public class SMSLogin extends JFrame implements ActionListener {

    private JTextField nameTextField = new JTextField(13);
    private JPasswordField pswField = new JPasswordField(13);
    private JLabel titleLabel = new JLabel("学生管理系统");
    private JLabel userNameLabel = new JLabel("用户名：");
    private JLabel pswLabel = new JLabel("密码：   ");
    private JButton logInBtn = new JButton("登录");
    private JButton registerBtn = new JButton("注册");
    private JButton forgotPswBtn = new JButton("忘记密码");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();

    public SMSLogin() {
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

        logInBtn.addActionListener(this);
        registerBtn.addActionListener(this);
        forgotPswBtn.addActionListener(this);

        this.setSize(300, 200);

//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-登陆");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == logInBtn) {
            String userName = nameTextField.getText();
            char[] passWord = pswField.getPassword();
            String psw = String.valueOf(passWord);
            SMSUserList userList = new SMSUserList();
            for (int i = 0; i < userList.getUserListCount(); ++i) {
                if ((userName.equals(userList.getUser(i).getUserName())) && (psw.equals(userList.getUser(i).getUserPsw()))) {
                    new SMSMainWindow();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "用户名密码错误！");
                }
            }
        } else if (a.getSource() == registerBtn) {
            new SMSRegister();
            this.setVisible(false);
        } else if (a.getSource() == forgotPswBtn) {
            new SMSForgetPsw();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SMSLogin();
    }

}
