package com.bistuSMS;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Xu Bo on 2015/4/13.
 */

public class SMSMainWindow extends JFrame{


    JButton returnButton = new JButton("注销账号");
    JButton removeButton = new JButton("删除学生");
    JButton addButton = new JButton("添加学生");
    JButton clearTableButton = new JButton("清除选中");

    Font font = new Font("Default",Font.PLAIN,20);
    Font titleFont = new Font("Default",Font.PLAIN,25);

    TitledBorder border1 = new TitledBorder("学生列表");
    static JTable studentListTable = new JTable();
    JLabel titleLabel;

    JPanel panel1 = new JPanel();
    JScrollPane panel2 = new JScrollPane();
    JPanel panel3 = new JPanel();

    public static SMSStudentArray studentArray = SMSXML.getStudents();

    public SMSMainWindow (String user){
        this.setTitle("学生管理系统");
        setLayout(null);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        titleLabel = new JLabel(user + "，欢迎使用！");
        titleLabel.setFont(titleFont);
        panel1.add(titleLabel);
        panel1.setBounds(0, 20, 800, 40);
        add(panel1);

        studentListTable.setModel(new TableModel() {
            @Override
            public int getRowCount() {
                return studentArray.studentListCount();
            }

            @Override
            public int getColumnCount() {
                return 6;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return new String[]{"姓名", "学号", "性别", "班级", "宿舍", "是否入党"}[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                SMSStudent s = studentArray.getSingleStudent(rowIndex);
                return new Object[]{s.getStuName(), s.getStuNumber(), s.getStuSex(), s.getStuClass(), s.getStuDorm(), s.getJoinCCP()}[columnIndex];
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                SMSStudent s = studentArray.getSingleStudent(rowIndex);
                switch (columnIndex) {
                    case 0:
                        s.setStuName((String) aValue);
                        break;
                    case 1:
                        s.setStuNumber((String) aValue);
                        break;
                    case 2:
                        s.setStuSex((String) aValue);
                        break;
                    case 3:
                        s.setStuClass((String) aValue);
                        break;
                    case 4:
                        s.setStuDorm((String) aValue);
                        break;
                    case 5:
                        s.setJoinCCP((String) aValue);
                    default:
                        break;
                }
            }

            @Override
            public void addTableModelListener(TableModelListener l) {
            }

            @Override
            public void removeTableModelListener(TableModelListener l) {

            }
        });

        border1.setTitleFont(font);
        panel2.setBorder(border1);
        panel2.setBounds(10, 80, 760, 400);
        panel2.add(studentListTable);

        add(panel2);
        panel2.setViewportView(studentListTable);
        panel3.setBounds(10, 500, 760, 100);
        panel3.add(returnButton);
        panel3.add(clearTableButton);
        panel3.add(addButton);
        panel3.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rows = studentListTable.getSelectedRows();
                studentListTable.clearSelection();
                if (rows.length != 0) {
                    studentArray.deleteStudent(rows[0]);
                    studentListTable.revalidate();
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SMSLogin(user);
                setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentListTable.getSelectedRowCount() == 0) {
                    int row = 0;
                    studentListTable.clearSelection();
                    new SMSAddStudent(row, studentArray);
                    studentListTable.revalidate();
                } else {
                    int[] rows = studentListTable.getSelectedRows();
                    studentListTable.clearSelection();
                    new SMSAddStudent(rows[0] + 1, studentArray);
                    studentListTable.revalidate();

                }
            }
        });
        clearTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentListTable.clearSelection();
            }
        });
        add(panel3);

        this.setVisible(true);
    }

    public static SMSStudentArray getStuArray() {
        return studentArray;
    }

}
