package com.gxuwz.attend.service;

import com.gxuwz.attend.dao.leaveDao;
import com.gxuwz.attend.dao.leaveDaoImp;
import com.gxuwz.attend.entity.*;

import java.util.List;

public class leaveservieImp implements leaveservice{
   private leaveDao leaveDao=new leaveDaoImp();
   //班级板块
    @Override
    public List<Classes> classes_information(int pageNow, int pageCount, String clsId) {
        return leaveDao.classes_information(pageNow,pageCount,clsId);
    }

    @Override
    public PageBean<Classes> getTotalRowsClasses(String pageInfo, int pageCount, String clsId) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsClasses();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<Classes> classes = leaveDao.classes_information(pageNow,pageCount,clsId);
        PageBean<Classes> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(classes);
        return pageBean;
    }

    @Override
    public void addclass(Classes classes) {
        leaveDao.addclass(classes);
    }

    @Override
    public List<Classes> sleeditclass(String clsId) {
        return leaveDao.sleeditclass(clsId);
    }

    @Override
    public void updaclass(Classes classes) {
        leaveDao.updaclass(classes);
    }

    @Override
    public void deleteclass(String clsId) {
        leaveDao.deleteclass(clsId);
    }


    //学生板块
    @Override
    public List<students> students_information(int pageNow, int pageCount, String stuNo) {
        return leaveDao.students_information(pageNow,pageCount,stuNo);
    }
    public PageBean<students> getTotalRowsstudents(String pageInfo, int pageCount, String stuNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsstudents();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<students> students = leaveDao.students_information(pageNow,pageCount,stuNo);
        PageBean<students> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(students);
        return pageBean;
    }
    @Override
    public int getTotalRowsstudents() {
        return leaveDao.getTotalRowsstudents();
    }

    @Override
    public void addstudents(students students) {
   leaveDao.addstudents(students);
    }

    @Override
    public void updastudents(students students) {
   leaveDao.updastudents(students);
    }

    @Override
    public void deletestudents(String stuNo) {
    leaveDao.deletestudents(stuNo);
    }

    @Override
    public List<students> sleeditstudents(String stuNo) {
        return leaveDao.sleeditstudents(stuNo);
    }


    //辅导员板块
    @Override
    public List<instructor> instructor_information(int pageNow, int pageCount, String insNo) {
        return leaveDao.instructor_information(pageNow,pageCount,insNo);
    }
    public PageBean<instructor> getTotalRowsinstructors(String pageInfo, int pageCount, String insNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsinstructor();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<instructor> instructor = leaveDao.instructor_information(pageNow,pageCount,insNo);
        PageBean<instructor> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(instructor);
        return pageBean;
    }
    @Override
    public int getTotalRowsinstructor() {
        return leaveDao.getTotalRowsinstructor();
    }

    @Override
    public void addinstructor(instructor instructor) {
        leaveDao.addinstructor(instructor);
    }

    @Override
    public void updainstructor(instructor instructor) {
        leaveDao.updainstructor(instructor);
    }

    @Override
    public void deleteinstructor(String insNo) {
        leaveDao.deleteinstructor(insNo);
    }

    @Override
    public List<instructor> sleeditinstructor(String insNo) {
        return leaveDao.sleeditinstructor(insNo);
    }

  //用户板块
  @Override
  public List<user> user_information(int pageNow, int pageCount, String userid) {
      return leaveDao.user_information(pageNow,pageCount,userid);
  }
    public PageBean<user> getTotalRowsuser(String pageInfo, int pageCount, String userid) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsuser();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<user> user = leaveDao.user_information(pageNow,pageCount,userid);
        PageBean<user> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(user);
        return pageBean;
    }
    @Override
    public int getTotalRowsuser() {
        return leaveDao.getTotalRowsuser();
    }

    @Override
    public void adduser(user user) {
        leaveDao.adduser(user);
    }

    @Override
    public void updauser(user user) {
        leaveDao.updauser(user);
    }

    @Override
    public void deleteuser(String userid) {
        leaveDao.deleteuser(userid);
    }

    @Override
    public List<user> sleedituser(String userid) {
        return leaveDao.sleedituser(userid);
    }


    //部门板块
    @Override
    public List<department> department_information(int pageNow, int pageCount, String depId) {
        return leaveDao.department_information(pageNow,pageCount,depId);
    }

    public PageBean<department> getTotalRowsdepartment(String pageInfo, int pageCount, String depId) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsdepartment();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<department> department = leaveDao.department_information(pageNow,pageCount,depId);
        PageBean<department> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(department);
        return pageBean;
    }

    @Override
    public int getTotalRowsdepartment() {
        return leaveDao.getTotalRowsdepartment();
    }

    @Override
    public void adddepartment(department department) {
      leaveDao.adddepartment(department);
    }

    @Override
    public void updadepartment(department department) {
      leaveDao.updadepartment(department);
    }

    @Override
    public void deletedepartment(String depId) {
     leaveDao.deletedepartment(depId);
    }

    @Override
    public List<department> sleeditdepartment(String depId) {
        return leaveDao.sleeditdepartment(depId);
    }



    //辅导员带班板块
    @Override
    public List<instructortask> instructortask_information(int pageNow, int pageCount, String insNo) {
        return leaveDao.instructortask_information(pageNow,pageCount,insNo);
    }

    public PageBean<instructortask> getTotalRowsinstructortask(String pageInfo, int pageCount, String insNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsinstructortask();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<instructortask> instructortask = leaveDao.instructortask_information(pageNow,pageCount,insNo);
        PageBean<instructortask> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(instructortask);
        return pageBean;
    }

    @Override
    public int getTotalRowsinstructortask() {
        return leaveDao.getTotalRowsinstructortask();
    }

    @Override
    public void addinstructortask(instructortask instructortask) {
        leaveDao.addinstructortask(instructortask);
    }

    @Override
    public void updainstructortask(instructortask instructortask) {
        leaveDao.updainstructortask(instructortask);
    }

    @Override
    public void deleteinstructortask(String insNo,String clsId) {
        leaveDao.deleteinstructortask(insNo,clsId);
    }

    @Override
    public List<instructortask> sleeditinstructortask(String insNo,String clsId) {
        return leaveDao.sleeditinstructortask(insNo,clsId);
    }


    //请假板块
    @Override
    public List<leave> leave_information(int pageNow, int pageCount, String userid,String stuNo) {
        return leaveDao.leave_information(pageNow,pageCount,userid,stuNo);
    }

    public PageBean<leave> getTotalRowsleave(String pageInfo, int pageCount,String userid, String stuNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsleave(userid);
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<leave> leave = leaveDao.leave_information(pageNow,pageCount,userid,stuNo);
        PageBean<leave> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(leave);
        return pageBean;
    }

    @Override
    public int getTotalRowsleave(String userid) {
        return leaveDao.getTotalRowsleave(userid);
    }

    @Override
    public void addleave(leave leave) {
        leaveDao.addleave(leave);
    }
   public void updaleave(String flag,String stuNo,String startTime){
        leaveDao.updaleave(flag,stuNo,startTime);
    }

    //审核请假板块
    @Override
    public List<leave> auditleave_information(int pageNow, int pageCount, String stuNo) {
        return leaveDao.auditleave_information(pageNow,pageCount,stuNo);
    }

    public PageBean<leave> getTotalRowsauditleave(String pageInfo, int pageCount, String stuNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsauditleave();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<leave> leave = leaveDao.auditleave_information(pageNow,pageCount,stuNo);
        PageBean<leave> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(leave);
        return pageBean;
    }

    @Override
    public int getTotalRowsauditleave() {
        return leaveDao.getTotalRowsauditleave();
    }
  public   List<statistics> statistics_information(String clsName,String startTime1,String startTime2){
        return leaveDao.statistics_information(clsName,startTime1,startTime2);
  }







    //审核请假板块
    @Override
    public List<leave> daoleave_information(int pageNow, int pageCount, String stuNo) {
        return leaveDao.daoleave_information(pageNow,pageCount,stuNo);
    }

    public PageBean<leave> getTotalRowsdaoleave(String pageInfo, int pageCount, String stuNo) {
        if (pageInfo == null)
        {
            pageInfo    = "1";
        }
        int pageNow = Integer.parseInt(pageInfo);
        int totalRows = leaveDao.getTotalRowsdaoleave();
        int totalPage = (totalRows % pageCount == 0) ? (totalRows / pageCount) : (totalRows / pageCount + 1);
        if (pageNow < 1){
            pageNow = 1;
        }
        if(pageNow > totalPage){
            pageNow = totalPage;
        }

        List<leave> leave = leaveDao.daoleave_information(pageNow,pageCount,stuNo);
        PageBean<leave> pageBean=new PageBean<>();
        pageBean.setTotalCount(totalRows);
        pageBean.setRows(leave);
        return pageBean;
    }

    @Override
    public int getTotalRowsdaoleave() {
        return leaveDao.getTotalRowsauditleave();
    }


    @Override
    public List<role> role_information() {
        return leaveDao.role_information();
    }
    @Override
    public List<meun> meun_information(String id) {
        return leaveDao.meun_information(id);
    }

    @Override
    public void deletemenu(String id, String psid) {
        leaveDao.deletemenu(id,psid);
    }
    public List<meuns> meuns(){
       return leaveDao.meuns();
    }
   public void addrele(String id,String psid){
        leaveDao.addrele(id, psid);
   }
}
