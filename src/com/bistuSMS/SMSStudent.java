package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/11.
 */

/**
 *  SMSStudent is a class to describe a student him/herself.
 *  There are 4 properties in SMSStudent: 'stuName', 'stuSex', 'stuClass', 'stuNumber'.
 *  This class provides 2 kinds of construction methods: a non-parametric method and a method with 4 Strings as its parametric to initialize properties.
 *  This class provides get/set methods for 4 properties above.
 *  ZHRMoe Studio, 2015.
 */

public class SMSStudent {

    private String stuName;
    private String stuSex;
    private String stuClass;
    private String stuNumber;

    public SMSStudent() {

    }

    public SMSStudent(String stuName, String stuSex, String stuClass, String stuNumber) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuClass = stuClass;
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public String getStuClass() {
        return stuClass;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

}
