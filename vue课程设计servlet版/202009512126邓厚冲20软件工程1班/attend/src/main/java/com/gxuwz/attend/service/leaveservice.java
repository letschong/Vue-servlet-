package com.gxuwz.attend.service;

import com.gxuwz.attend.entity.*;

import java.util.List;

public interface leaveservice {
    //班级信息
    List<Classes> classes_information(int pageNow, int pageCount, String clsId);
    PageBean<Classes> getTotalRowsClasses(String pageInfo, int pageCount, String clsId);
    public void addclass(Classes classes);
    List<Classes> sleeditclass(String clsId);
    void updaclass(Classes classes);
    void deleteclass(String clsId);

    //学生
    List<students> students_information(int pageNow, int pageCount, String stuNo);
    public PageBean<students> getTotalRowsstudents(String pageInfo, int pageCount, String stuNo);
    int getTotalRowsstudents();
    void addstudents(students students);
    void updastudents(students students);
    void deletestudents(String stuNo);
    List<students> sleeditstudents(String stuNo);

    //辅导员板块
    List<instructor> instructor_information(int pageNow, int pageCount, String insNo);
    public PageBean<instructor> getTotalRowsinstructors(String pageInfo, int pageCount, String insNo);
    int getTotalRowsinstructor();
    void addinstructor(instructor instructor);
    void updainstructor(instructor instructor);
    void deleteinstructor(String insNo);
    List<instructor> sleeditinstructor(String insNo);

    //用户板块
    List<user> user_information(int pageNow, int pageCount, String userid);
    public PageBean<user> getTotalRowsuser(String pageInfo, int pageCount, String clsId);
    int getTotalRowsuser();
    void adduser(user user);
    void updauser(user user);
    void deleteuser(String userid);
    List<user> sleedituser(String userid);

    //部门板块
    List<department> department_information(int pageNow, int pageCount, String depId);
    public PageBean<department> getTotalRowsdepartment(String pageInfo, int pageCount, String depId);
    int getTotalRowsdepartment();
    void adddepartment(department department);
    void updadepartment(department department);
    void deletedepartment(String depId);
    List<department> sleeditdepartment(String depId);

    //部门板块
    List<instructortask> instructortask_information(int pageNow, int pageCount, String insNo);
    public PageBean<instructortask> getTotalRowsinstructortask(String pageInfo, int pageCount, String insNo);
    int getTotalRowsinstructortask();
    void addinstructortask(instructortask instructortask);
    void updainstructortask(instructortask instructortask);
    void deleteinstructortask(String insNo,String clsId);
    List<instructortask> sleeditinstructortask(String insNo,String clsId);

    //请假条板块
    List<leave> leave_information(int pageNow, int pageCount,String userid, String stuNo);
    public PageBean<leave> getTotalRowsleave(String pageInfo, int pageCount, String userid,String stuNo);
    int getTotalRowsleave(String userid);
    void addleave(leave leave);
    void updaleave(String flag,String stuNo,String startTime);

    //审核请假条板块
    List<leave> auditleave_information(int pageNow, int pageCount, String stuNo);
    public PageBean<leave> getTotalRowsauditleave(String pageInfo, int pageCount, String stuNo);
    int getTotalRowsauditleave();
    List<statistics> statistics_information(String clsName,String startTime1,String startTime2);

    public List<leave> daoleave_information(int pageNow, int pageCount, String stuNo);
    public PageBean<leave> getTotalRowsdaoleave(String pageInfo, int pageCount, String stuNo);
    public int getTotalRowsdaoleave();

    //权限管理
    List<role> role_information();
    List<meun> meun_information(String id);
    public void deletemenu(String id, String psid);
    public List<meuns> meuns();
    void addrele(String id,String psid);
}
