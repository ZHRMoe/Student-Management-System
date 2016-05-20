package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/12.
 */

public class SMSStudentArray {

    private ArrayList<SMSStudent> studentList = new ArrayList<SMSStudent>();

    public SMSStudentArray() {
    }

    public ArrayList getStudentList() {
        return studentList;
    }

    public SMSStudent getSingleStudent(int position) {
        return studentList.get(position);
    }

    public void addStudent(int position, SMSStudent stu) {
        try {
            SMSXML.addStudent(stu);
            studentList = SMSXML.getStudents().getStudentList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editStudent(int locationBeforeEdit, SMSStudent stuAfterEdit) {
        try {
            SMSXML.removeStudent(studentList.get(locationBeforeEdit));
            SMSXML.addStudent(stuAfterEdit);
            studentList = SMSXML.getStudents().getStudentList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentArray(int[] array) {
        for(int i = array.length - 1; i >= 0; --i) {
            SMSXML.removeStudent(studentList.get(array[i]));
        }
        studentList = SMSXML.getStudents().getStudentList();
    }

    public void deleteStudent(int locationBeforeDelete) {
        SMSXML.removeStudent(studentList.get(locationBeforeDelete));
        studentList = SMSXML.getStudents().getStudentList();
    }

    public int studentListCount() {
        return studentList.size();
    }

}
