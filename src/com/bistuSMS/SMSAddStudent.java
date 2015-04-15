package com.bistuSMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ZHRMoe on 15/4/15.
 */
public class SMSAddStudent extends JFrame implements ActionListener {

    public JTextField stuNameTextField = new JTextField(13);
    public JTextField stuSexTextField = new JTextField(13);
    public JTextField stuClassTextField = new JTextField(13);
    public JTextField stuNumberTextField = new JTextField(13);
    public JLabel titleLabel = new JLabel("添加新学生");
    public JLabel nameLabel = new JLabel("姓名：");
    public JLabel sexLabel = new JLabel("性别：         ");
    public JLabel blankLabel = new JLabel("         ");
    public JLabel classLabel = new JLabel("班级：");
    public JLabel numberLabel = new JLabel("学号：");
    public JButton addBtn = new JButton("添加");
    public JButton backBtn = new JButton("取消");
    public JPanel panel1 = new JPanel();
    public JPanel panel2 = new JPanel();
    public JPanel panel3 = new JPanel();
    public JPanel panel4 = new JPanel();
    public JPanel panel5 = new JPanel();
    public JPanel panel6 = new JPanel();
    public String sex = new String("男");
    public ButtonGroup sexButtonGroup = new ButtonGroup();
    public JRadioButton maleRadioButton = new JRadioButton("男", true);
    public JRadioButton femaleRadioButton = new JRadioButton("女");
    public SMSStudent addStudent;
    public SMSStudentArray stuArray = SMSMainWindow.getStuArray();
    public boolean addSucceed = false;
    public boolean windowClosed = false;
    public int position;

    public SMSAddStudent(int position, SMSStudentArray stuArray) {
        this.setLayout(new GridLayout(6, 1));
        this.position = position;
        panel1.add(titleLabel);

        panel2.add(nameLabel);
        panel2.add(stuNameTextField);

        backBtn.addActionListener(this);
        addBtn.addActionListener(this);
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "男";
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "女";
            }
        });

        sexButtonGroup.add(maleRadioButton);
        sexButtonGroup.add(femaleRadioButton);

        panel3.add(sexLabel);
        panel3.add(maleRadioButton);
        panel3.add(blankLabel);
        panel3.add(femaleRadioButton);
        panel3.add(blankLabel);

        panel4.add(classLabel);
        panel4.add(stuClassTextField);

        panel5.add(numberLabel);
        panel5.add(stuNumberTextField);

        panel6.add(backBtn);
        panel6.add(addBtn);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);

        this.setSize(300, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("学生管理系统-添加新学生");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == addBtn) {
            addStudent = new SMSStudent(stuNameTextField.getText(), sex, stuClassTextField.getText(), stuNumberTextField.getText());
            stuArray.addStudent(position, addStudent);
            addSucceed = true;
            windowClosed = true;
            this.setVisible(false);
            SMSMainWindow.studentListTable.updateUI();
        } else if (a.getSource() == backBtn) {
            this.setVisible(false);
        }
    }

}
