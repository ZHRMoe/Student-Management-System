package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/12.
 */

public class SMSStudentArray {

    private ArrayList<SMSStudent> studentList = new ArrayList<SMSStudent>();

    public SMSStudentArray() {
//        for (int i = 0; i <= 4; ++i) {
//            SMSStudent newStudent = new SMSStudent(String.format("Student%d", i), "男", "计类1403", String.format("201401100%d", i), String.format("1-10%d", i), "是");
//            studentList.add(newStudent);
//        }
//        for (int i = 5; i < 10; ++i) {
//            SMSStudent newStudent = new SMSStudent(String.format("Student%d", i), "女", "计类1403", String.format("201401100%d", i), String.format("3-10%d", i), "否");
//            studentList.add(newStudent);
//        }
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

//    public void deleteSomeStudent(int startPosition, int endPosition) {
//        for (int i = startPosition; i < endPosition; ++i) {
//            studentList.remove(i);
//        }
//    }

    public int studentListCount() {
        return studentList.size();
    }

}
