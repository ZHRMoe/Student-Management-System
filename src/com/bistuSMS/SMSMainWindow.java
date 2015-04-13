package com.bistuSMS;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasee on 2015/4/13.
 */
public class SMSMainWindow extends JFrame {
    JLabel titleLabel = new JLabel("Student-Management-System");
    JButton enterButton = new JButton("进入");
    JButton exitButton = new JButton("退出");
    JLabel informationLabel = new JLabel("Powered by 张浩然 许博");
    public SMSMainWindow() {
        setLayout(new BorderLayout(5,5));
        add(titleLabel, BorderLayout.NORTH);
        add(enterButton, BorderLayout.WEST);
        add(exitButton, BorderLayout.EAST);
        add(informationLabel, BorderLayout.SOUTH);
        enterButton.setSize(100, 30);
        exitButton.setSize(30,30);
        this.setTitle("Student-Management-System");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
