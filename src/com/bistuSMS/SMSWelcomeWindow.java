package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bill on 15/4/14.
 */

public class SMSWelcomeWindow extends JFrame {
    public static void main(String[] args) {
        new SMSWelcomeWindow();
    }

    private JLabel titleLabel;
    private JLabel membersLabel;
    private JLabel bigStringSLabel;
    private JButton loginButton;
    private JButton quitButton;
    private JPanel titlePanel;
    private JPanel membersPanel;
    private JPanel bigStringSPanel;
    private JPanel southPanel;
    private Font font = new Font("Default",Font.PLAIN, 20);
    private Font big = new Font("Default", Font.HANGING_BASELINE, 400);
    public SMSWelcomeWindow() {
        titleLabel = new JLabel("Welcome");
        titleLabel.setFont(font);
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        membersLabel = new JLabel("Powered by Hu Bo, Xu Bo and Zhang Haoran");
        membersPanel = new JPanel();
        loginButton = new JButton("登陆");
        bigStringSLabel = new JLabel("S");
        bigStringSLabel.setFont(big);
        bigStringSPanel = new JPanel();
        bigStringSPanel.add(bigStringSLabel, BorderLayout.CENTER);
        bigStringSPanel.add(membersPanel, BorderLayout.SOUTH);

        quitButton = new JButton("退出");
        southPanel = new JPanel();
        southPanel.add(membersPanel, BorderLayout.SOUTH);
        southPanel.add(loginButton, BorderLayout.WEST);
        southPanel.add(quitButton, BorderLayout.EAST);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(bigStringSPanel,BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setSize(800, 600);
        this.setTitle("Student Management System");
        this.setVisible(true);
    }
}
