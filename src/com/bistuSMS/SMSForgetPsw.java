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

public class SMSForgetPsw extends JFrame implements ActionListener{

    private JTextField nameTextField = new JTextField(13);
    private JPasswordField pswField = new JPasswordField(13);
    private JPasswordField confirmPswField = new JPasswordField(13);
    private JLabel titleLabel = new JLabel("忘记密码");
    private JLabel userNameLabel = new JLabel("用户名：    ");
    private JLabel pswLabel = new JLabel("密码：       ");
    private JLabel confirmPswLabel = new JLabel("确认密码：");
    private JButton changePswBtn = new JButton("修改密码");
    private JButton backBtn = new JButton("返回");
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();

    public SMSForgetPsw() {

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

        changePswBtn.addActionListener(this);
        backBtn.addActionListener(this);

        this.setSize(300, 200);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("学生管理系统-忘记密码");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == changePswBtn) {
            String userName = nameTextField.getText();
            char[] passWord = pswField.getPassword();
            char[] confirmPsw = confirmPswField.getPassword();
            String psw = String.valueOf(passWord);
            String conPsw = String.valueOf(confirmPsw);
            SMSUserList userList = SMSStart.getUserList();
            boolean changePswFlag = false;
            if (psw.equals(conPsw)) {
                for (int i = 0; i < userList.getUserListCount(); ++i) {
                    if (userList.getUser(i).getUserName().equals(userName)) {
                        SMSUser newUser = new SMSUser(userName, psw);
                        userList.forgotPsw(i, newUser);
                        changePswFlag = true;
                        new SMSLogin(userName);
                        this.setVisible(false);
                    }
                }
                if (!changePswFlag) {
                    JOptionPane.showMessageDialog(null, "用户名不存在");
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
