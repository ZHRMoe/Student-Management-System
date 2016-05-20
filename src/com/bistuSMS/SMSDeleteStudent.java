package com.bistuSMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bill on 16/5/20.
 */
public class SMSDeleteStudent extends JFrame implements ActionListener {
    private JButton SMSYes, SMSNo;
    private JPanel SMSButtonPanel;
    private JPanel SMSTextPannel;
    public SMSStudentArray stuArray = SMSMainWindow.getStuArray();
    int[] row;

    public SMSDeleteStudent(int[] row) {
        this.row = row;
        if (row.length == 0) {
            return;
        }
        SMSStudent student = SMSMainWindow.studentArray.getSingleStudent(row[0]);
        SMSYes = new JButton("确认");
        SMSNo = new JButton("取消");
        SMSButtonPanel = new JPanel();
        SMSButtonPanel.add(SMSYes);
        SMSButtonPanel.add(SMSNo);
        SMSTextPannel = new JPanel();
        JLabel label = new JLabel("真的要删除"+student.getStuName()+"等学生吗?");
        SMSTextPannel.add(label);
        this.setLayout(new GridLayout(2, 1));
        this.add(SMSTextPannel);
        this.add(SMSButtonPanel);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("删除学生");
        SMSYes.addActionListener(this);
        SMSNo.getRootPane().setDefaultButton(SMSNo);
        SMSNo.addActionListener(this);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SMSYes) {
            stuArray.deleteStudentArray(row);
            this.setVisible(false);
            SMSMainWindow.studentListTable.updateUI();
        } else if (e.getSource() == SMSNo) {
            this.setVisible(false);
        }
    }
}
