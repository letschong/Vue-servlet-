package com.gxuwz.attend.entity;

public class students {
    private String stuNo;
    private String stuName;
    private String stuSex;
    private String clsId;
    private String stuPwd;


    public students(String stuNo, String stuName, String stuSex, String clsId, String stuPwd) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.clsId = clsId;
        this.stuPwd = stuPwd;
    }

    public students() {
    }

    public students(String stuNo, String stuPwd) {
        this.stuNo = stuNo;
        this.stuPwd = stuPwd;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    @Override
    public String toString() {
        return "students{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", clsId='" + clsId + '\'' +
                '}';
    }
}
