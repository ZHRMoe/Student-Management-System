package com.bistuSMS;

import java.util.ArrayList;

/**
 * Created by ZHRMoe on 15/4/12.
 */

/**
 * SMSStudentArray is a class to describe a group of students, based on ArrayList(java.util.*).
 * There is only one ArrayList property named studentList in this class.
 * This class provides only one construction method without parametric.
 * This class provides 4 methods to manage the list:
   'getStudentList' is a method to get the list of SMSStudent type cases.
   'addStudent' is a method to add SMSStudent type case into the ArrayList, a parametric is needed to be added. (The default implementation to it adds the case at the end of the ArrayList)
   'editStudent' is a method to edit SMSStudent type case into another SMSStudent type case, two parametric are needed to get the int type location to edit, and an SMSStudent type case after edit.
   'deleteStudent' is a method to delete SMSStudent type case from the ArrayList, a parametric is needed to locate.
   'checkStudent' is a method returned String type, you can use this method to get words will be shown in the window.
 * ZHRMoe Studio, 2015.
 */

public class SMSStudentArray {

    private ArrayList<SMSStudent> studentList = new ArrayList<SMSStudent>();

    public SMSStudentArray() {

    }

    public ArrayList getStudentList() {
        return studentList;
    }

    public void addStudent(SMSStudent stu) {
        studentList.add(stu);
    }

    public void editStudent(int locationBeforeEdit, SMSStudent stuAfterEdit) {
        studentList.remove(locationBeforeEdit);
        studentList.add(locationBeforeEdit, stuAfterEdit);
    }

    public void deleteStudent(int locationBeforeDelete) {
        studentList.remove(locationBeforeDelete);
    }

    public String checkStudent(SMSStudent stu) {
        return "Name: " + stu.getStuName() + "\nSex: " + stu.getStuSex() + "\nClass: " + stu.getStuClass() + "\nNumber: " + stu.getStuNumber();
    }

}
