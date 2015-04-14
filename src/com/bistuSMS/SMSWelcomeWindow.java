package com.bistuSMS;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bill on 15/4/14.
 */
public class SMSWelcomeWindow extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new SMSWelcomeWindow();
    }

    private JLabel SMSWelcome;
    private JLabel SMSSMSLabel;
    private JLabel SMSWelcomeMembers;
    private JButton SMSWelcomeLogin, SMSWelcomeQuit;

    private JPanel[] SMSWelcomePanel = new JPanel[4];

    private Font SMSFontDefault = new Font("Default",Font.PLAIN,15);
    private Font SMSFontMonaco = new Font("Monaco",Font.PLAIN,30);

    public SMSWelcomeWindow() {
        SMSWelcome = new JLabel("欢迎进入");
        SMSWelcome.setFont(SMSFontDefault);
        SMSSMSLabel = new JLabel("学生管理系统");
        SMSSMSLabel.setFont(SMSFontMonaco);
        SMSWelcomeLogin = new JButton("开始");
        SMSWelcomeQuit = new JButton("退出");
        SMSWelcomeMembers = new JLabel("Powered by Haoran Zhang, Bo Xu, Bo Hu");
        SMSWelcomeMembers.setFont(new Font("Default",Font.PLAIN,13));

        SMSWelcomePanel = new JPanel[4];
        for(int i=0;i<4;++i) { SMSWelcomePanel[i] = new JPanel();}
        SMSWelcomePanel[0].add(SMSWelcome);
        SMSWelcomePanel[1].add(SMSSMSLabel);
        SMSWelcomePanel[2].add(SMSWelcomeLogin);
        SMSWelcomePanel[2].add(SMSWelcomeQuit);
        SMSWelcomePanel[3].add(SMSWelcomeMembers);

        this.setLayout(new GridLayout(4, 1));
        for(int i=0;i<4;++i) {
            this.add(SMSWelcomePanel[i]);
        }
        this.setVisible(true);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("学生信息管理系统");
        SMSWelcomeLogin.addActionListener(this);
        SMSWelcomeLogin.getRootPane().setDefaultButton(SMSWelcomeLogin);
        SMSWelcomeQuit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent buttonAction) {
        if(buttonAction.getSource() == SMSWelcomeLogin) {
            new SMSLogin();
            this.setVisible(false);
        } else if(buttonAction.getSource() == SMSWelcomeQuit) {
            System.exit(0);
        }
    }

}
