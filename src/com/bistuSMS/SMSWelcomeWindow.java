package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bill on 15/4/14.
 */
public class SMSWelcomeWindow extends JFrame {
    public static void main(String[] args) {
        new WelcomeWindow();
    }

    private JLabel titleLabel;
    private JLabel membersLabel;
    private JPanel titlePanel;
    private JPanel membersPanel;
    public WelcomeWindow() {
        titleLabel = new JLabel("Welcome");
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        membersLabel = new JLabel("Powered by Haoran Zhang, Bo Xu, Bo Hu");
        membersPanel = new JPanel();
        membersPanel.add(membersLabel);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(membersLabel, BorderLayout.SOUTH);
        this.setSize(800, 600);
        this.setTitle("Student Management System");
        this.setVisible(true);

    }
}
