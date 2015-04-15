package com.bistuSMS;

/**
 * Created by ZHRMoe on 15/4/11.
 */


public class SMSStudent {

    private String stuName;
    private String stuSex;
    private String stuClass;
    private String stuNumber;
    private String stuDorm;
    private boolean joinCCP;

    public SMSStudent() {

    }

    public SMSStudent(String stuName, String stuSex, String stuClass, String stuNumber, String stuDorm, boolean joinCCP) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuClass = stuClass;
        this.stuNumber = stuNumber;
        this.stuDorm = stuDorm;
        this.joinCCP = joinCCP;
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

    public String getStuDorm() {
        return stuDorm;
    }

    public boolean isJoinCCP() {
        return joinCCP;
    }

    public String getjoinString() {
        if (isJoinCCP()) {
            return "是";
        } else {
            return "否";
        }
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

    public void setStuDorm(String stuDorm) {
        this.stuDorm = stuDorm;
    }

    public void setJoinCCP(boolean joinCCP) {
        this.joinCCP = joinCCP;
    }

}
