package com.bistuSMS;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by hasee on 2015/4/13.
 */
public class SMSMainWindow extends JFrame {
    JButton returnButton = new JButton("return");
    JButton removeButton = new JButton("remove");
    Font font = new Font("Default",Font.PLAIN,20);
    Font titleFont = new Font("Default",Font.PLAIN,25);
    TitledBorder border1 = new TitledBorder("classMember");
    JTable studentListTable = new JTable();

    JLabel titleLabel;

    JPanel panel1 = new JPanel();
    JScrollPane panel2 = new JScrollPane();
    JPanel panel3 = new JPanel();

    public SMSMainWindow (String user){


        SMSStudentArray studentArray = new SMSStudentArray();
        setLayout(null);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        titleLabel = new JLabel(user);
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
                return 4;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return new String[]{"name", "number", "sex", "class"}[columnIndex];
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
                return new Object[]{s.getStuName(), s.getStuNumber(), s.getStuSex(), s.getStuClass()}[columnIndex];
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
//
        add(panel2);
        panel2.setViewportView(studentListTable);
        panel3.setBounds(10, 500, 760, 100);
        panel3.add(returnButton);
        panel3.add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rows = studentListTable.getSelectedRows();
                studentListTable.clearSelection();
                if (rows.length != 0) {
                    studentArray.deleteStudentArray(rows);
                    studentListTable.revalidate();
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SMSLogin();
                setVisible(false);
            }
        });
        add(panel3);
    }
}
