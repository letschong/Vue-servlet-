package com.gxuwz.attend.dao;

import com.gxuwz.attend.entity.*;

import java.util.List;

public interface leaveDao {
    //班级信息
    List<Classes> classes_information(int pageNow, int pageCount, String clsId);
    int getTotalRowsClasses();
    void addclass(Classes classes);
    void updaclass(Classes classes);
    void deleteclass(String clsId);
    List<Classes> sleeditclass(String clsId);

    //学生信息
    List<students> students_information(int pageNow, int pageCount, String stuNo);
    int getTotalRowsstudents();
    void addstudents(students students);
    void updastudents(students students);
    void deletestudents(String stuNo);
    List<students> sleeditstudents(String stuNo);

    //辅导员板块
    List<instructor> instructor_information(int pageNow, int pageCount, String insNo);
    int getTotalRowsinstructor();
    void addinstructor(instructor instructor);
    void updainstructor(instructor instructor);
    void deleteinstructor(String insNo);
    List<instructor> sleeditinstructor(String insNo);

    //用户板块
    List<user> user_information(int pageNow, int pageCount, String userid);
    int getTotalRowsuser();
    void adduser(user user);
    void updauser(user user);
    void deleteuser(String userid);
    List<user> sleedituser(String userid);

    //department部门板块
    List<department> department_information(int pageNow, int pageCount, String depId);
    int getTotalRowsdepartment();
    void adddepartment(department department);
    void updadepartment(department department);
    void deletedepartment(String userid);
    List<department> sleeditdepartment(String depId);

    //辅导员带班
    List<instructortask> instructortask_information(int pageNow, int pageCount, String insNo);
    int getTotalRowsinstructortask();
    void addinstructortask(instructortask instructortask);
    void updainstructortask(instructortask instructortask);
    void deleteinstructortask(String insNo,String clsId);
    List<instructortask> sleeditinstructortask(String insNo,String clsId);

    //请假条板块
    List<leave> leave_information(int pageNow, int pageCount,String userid, String stuNo);
    int getTotalRowsleave(String userid);
    void addleave(leave leave);
    void updaleave(String flag,String stuNo,String startTime);
    //审核请假条
    List<leave> auditleave_information(int pageNow, int pageCount, String stuNo);
    int getTotalRowsauditleave();

    //统计
    List<statistics> statistics_information(String clsName,String startTime1,String startTime2);

    //导出
    public List<leave> daoleave_information(int pageNow, int pageCount, String stuNo);
    public int getTotalRowsdaoleave();

    //权限管理
    List<role> role_information();
    List<meun> meun_information(String id);
    public void deletemenu(String id, String psid);
    public List<meuns> meuns();
    void addrele(String id,String psid);


}
