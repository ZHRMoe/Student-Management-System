package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/12.
 */

public class SMSStudentArray {

    private ArrayList<SMSStudent> studentList = new ArrayList<SMSStudent>();

    public SMSStudentArray() {
        for (int i = 0; i <= 5; ++i) {
            SMSStudent newStudent = new SMSStudent(String.format("Student%6d", i), "男", "计类1403", String.format("2014011%3d", i));
            studentList.add(newStudent);
        }
        for (int i = 6; i <= 10; ++i) {
            SMSStudent newStudent = new SMSStudent(String.format("Student%6d", i), "女", "计类1403", String.format("2014011%3d", i));
            studentList.add(newStudent);
        }
    }

    public ArrayList getStudentList() {
        return studentList;
    }

    public SMSStudent getSingleStudent(int position) {
        return studentList.get(position);
    }

    public void addStudent(int position, SMSStudent stu) {
        studentList.add(position, stu);
    }

    public void editStudent(int locationBeforeEdit, SMSStudent stuAfterEdit) {
        studentList.remove(locationBeforeEdit);
        studentList.add(locationBeforeEdit, stuAfterEdit);
    }

    public void deleteStudentArray(int[] array) {
        for(int i = array.length - 1; i >= 0; --i) {
            studentList.remove(i);
        }
    }

    public void deleteStudent(int locationBeforeDelete) {
        studentList.remove(locationBeforeDelete);
    }

    public void deleteSomeStudent(int startPosition, int endPosition) {
        for (int i = startPosition; i < endPosition; ++i) {
            studentList.remove(i);
        }
    }

    public String checkStudent(SMSStudent stu) {
        return "Name: " + stu.getStuName() + "\nSex: " + stu.getStuSex() + "\nClass: " + stu.getStuClass() + "\nNumber: " + stu.getStuNumber();
    }

    public int studentListCount() {
        return studentList.size();
    }

}
