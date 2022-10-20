package com.gxuwz.attend.dao;

import com.gxuwz.attend.config.DbUtil;
import com.gxuwz.attend.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class leaveDaoImp implements leaveDao {
    DbUtil dbUtil = new DbUtil();

    @Override
    public List<Classes> classes_information(int pageNow, int pageCount, String clsId) {
        List<Classes> classess = new ArrayList<Classes>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from classes where clsId like ? limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + clsId + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                classess.add(classes);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classess;
    }

    @Override
    public int getTotalRowsClasses() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select count(*) from classes ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void addclass(Classes classes) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into classes(clsId,clsName,clsMajor,depId,clsGrade)values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, classes.getClsId());
            pstmt.setString(paraIndex++, classes.getClsName());
            pstmt.setString(paraIndex++, classes.getClsMajor());
            pstmt.setString(paraIndex++, classes.getDepId());
            pstmt.setString(paraIndex++, classes.getClsGrade());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updaclass(Classes classes) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update classes set clsName=?,clsMajor=?,depId=?,clsGrade=? where clsId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, classes.getClsName());
            pstmt.setString(paraIndex++, classes.getClsMajor());
            pstmt.setString(paraIndex++, classes.getDepId());
            pstmt.setString(paraIndex++, classes.getClsGrade());
            pstmt.setString(paraIndex++, classes.getClsId());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteclass(String clsId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from classes  where clsId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, clsId);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Classes> sleeditclass(String clsId) {
        List<Classes> classess = new ArrayList<Classes>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from classes where clsId =? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clsId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Classes classes = new Classes(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                classess.add(classes);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classess;
    }

    //学生
    public List<students> students_information(int pageNow, int pageCount, String stuNo) {
        List<students> studentss = new ArrayList<students>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from student where stuNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + stuNo + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students students = new students(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                studentss.add(students);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentss;
    }

    @Override
    public int getTotalRowsstudents() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select count(*) from student ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void addstudents(students students) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into student(stuNo,stuName,stuSex,clsId,stuPwd)values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, students.getStuNo());
            pstmt.setString(paraIndex++, students.getStuName());
            pstmt.setString(paraIndex++, students.getStuSex());
            pstmt.setString(paraIndex++, students.getClsId());
            pstmt.setString(paraIndex++, students.getStuPwd());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updastudents(students students) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update student set stuName=?,stuSex=?,clsId=?,stuPwd=? where stuNo=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, students.getStuName());
            pstmt.setString(paraIndex++, students.getStuSex());
            pstmt.setString(paraIndex++, students.getClsId());
            pstmt.setString(paraIndex++, students.getStuPwd());
            pstmt.setString(paraIndex++, students.getStuNo());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deletestudents(String stuNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from student  where stuNo=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, stuNo);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<students> sleeditstudents(String stuNo) {
        List<students> studentss = new ArrayList<students>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from student where stuNo =? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stuNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students students = new students(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                studentss.add(students);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentss;
    }

    //辅导员板块
    public List<instructor> instructor_information(int pageNow, int pageCount, String insNo) {
        List<instructor> instructors = new ArrayList<instructor>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from instructor where insNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + insNo + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                instructor instructor = new instructor(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                instructors.add(instructor);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructors;
    }

    @Override
    public int getTotalRowsinstructor() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select count(*) from instructor ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void addinstructor(instructor instructor) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into instructor(insNo,insName,insPwd,depId,telephone)values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, instructor.getInsNo());
            pstmt.setString(paraIndex++, instructor.getInsName());
            pstmt.setString(paraIndex++, instructor.getInsPwd());
            pstmt.setString(paraIndex++, instructor.getDepId());
            pstmt.setString(paraIndex++, instructor.getTelephone());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updainstructor(instructor instructor) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update instructor set insName=?,insPwd=?,depId=?,telephone=? where insNo=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, instructor.getInsName());
            pstmt.setString(paraIndex++, instructor.getInsPwd());
            pstmt.setString(paraIndex++, instructor.getDepId());
            pstmt.setString(paraIndex++, instructor.getTelephone());
            pstmt.setString(paraIndex++, instructor.getInsNo());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteinstructor(String insNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from instructor  where insNo=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, insNo);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<instructor> sleeditinstructor(String insNo) {
        List<instructor> instructors = new ArrayList<instructor>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from instructor where insNo =? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, insNo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                instructor instructor = new instructor(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                instructors.add(instructor);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructors;
    }

    //用户板块
    public List<user> user_information(int pageNow, int pageCount, String userid) {
        List<user> users = new ArrayList<user>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from user where userid like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + userid + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user user = new user(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
                users.add(user);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int getTotalRowsuser() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select count(*) from user ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void adduser(user user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into user(userid,fullname,password,depId,telephone)values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, user.getUserid());
            pstmt.setString(paraIndex++, user.getFullname());
            pstmt.setString(paraIndex++, user.getPassword());
            pstmt.setString(paraIndex++, user.getDepId());
            pstmt.setString(paraIndex++, user.getTelephone());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updauser(user user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update user set fullname=?,password=?,depId=?,telephone=? where userid=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, user.getFullname());
            pstmt.setString(paraIndex++, user.getPassword());
            pstmt.setString(paraIndex++, user.getDepId());
            pstmt.setString(paraIndex++, user.getTelephone());
            pstmt.setString(paraIndex++, user.getUserid());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteuser(String userid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from user  where userid=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, userid);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<user> sleedituser(String userid) {
        List<user> users = new ArrayList<user>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from user where userid =? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user user = new user(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
                users.add(user);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //部门板块
    public List<department> department_information(int pageNow, int pageCount, String depId) {
        List<department> departments = new ArrayList<department>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from department where depId like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + depId + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                department department = new department(rs.getString(1), rs.getString(2),
                        rs.getString(3));
                departments.add(department);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public int getTotalRowsdepartment() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select count(*) from department ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void adddepartment(department department) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into department(depId,depName,depaType)values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, department.getDepId());
            pstmt.setString(paraIndex++, department.getDepName());
            pstmt.setString(paraIndex++, department.getDepaType());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updadepartment(department department) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update department set depName=?,depaType=? where depId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, department.getDepName());
            pstmt.setString(paraIndex++, department.getDepaType());
            pstmt.setString(paraIndex++, department.getDepId());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deletedepartment(String depId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from department  where depId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, depId);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<department> sleeditdepartment(String depId) {
        List<department> departments = new ArrayList<department>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from department where depId =? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, depId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                department department = new department(rs.getString(1), rs.getString(2),
                        rs.getString(3));
                departments.add(department);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    //辅导员带班板块
    public List<instructortask> instructortask_information(int pageNow, int pageCount, String insNo) {
        List<instructortask> instructortasks = new ArrayList<instructortask>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT  * from instructortask  NATURAL JOIN classes NATURAL JOIN instructor WHERE insNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + insNo + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                instructortask instructortask = new instructortask(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                        , rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
                instructortasks.add(instructortask);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructortasks;
    }

    @Override
    public int getTotalRowsinstructortask() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = " select count(*) from instructortask  NATURAL JOIN classes NATURAL JOIN instructor ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void addinstructortask(instructortask instructortask) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into instructortask(insNo,clsId,startTime,startTerm)values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, instructortask.getInsNo());
            pstmt.setString(paraIndex++, instructortask.getClsId());
            pstmt.setString(paraIndex++, instructortask.getStartTime());
            pstmt.setString(paraIndex++, instructortask.getStartTerm());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updainstructortask(instructortask instructortask) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update instructortask set StartTime=?,StartTerm=? where insNo=? and ClsId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, instructortask.getStartTime());
            pstmt.setString(paraIndex++, instructortask.getStartTerm());
            pstmt.setString(paraIndex++, instructortask.getInsNo());
            pstmt.setString(paraIndex++, instructortask.getClsId());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteinstructortask(String insNo, String clsId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from instructortask  where insNo=? and clsId=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, insNo);
            pstmt.setString(paraIndex++, clsId);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<instructortask> sleeditinstructortask(String insNo,String clsId) {
        List<instructortask> instructortasks = new ArrayList<instructortask>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from instructortask where insNo =? and clsId=? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, insNo);
            pstmt.setString(2, clsId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                instructortask instructortask = new instructortask(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                instructortasks.add(instructortask);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instructortasks;
    }

    //请假条板块
    public List<leave> leave_information(int pageNow, int pageCount,String userid, String stuNo) {
        List<leave> leaves = new ArrayList<leave>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT  * from  student  NATURAL JOIN  `leave` NATURAL JOIN instructor  WHERE stuNo=? and stuNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  userid );
            pstmt.setString(2, "%" + stuNo + "%");
            pstmt.setInt(3, (pageNow - 1) * pageCount);
            pstmt.setInt(4, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                leave leave = new leave(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                        , rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getFloat(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
                leaves.add(leave);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaves;
    }

    @Override
    public int getTotalRowsleave(String userid) {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = " select count(*) from student  NATURAL JOIN  `leave` NATURAL JOIN instructor where stuNo=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  userid );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public void addleave(leave leave) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "insert into `leave`(leaveNo,reason,startTime,endTime,stuNo,days,insNo,createTime,flag,types)values(?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, leave.getLeaveNo());
            pstmt.setString(2 ,leave.getReason());
            pstmt.setString(3, leave.getStartTime());
            pstmt.setString(4, leave.getEndTime());
            pstmt.setString(5, leave.getStuNo());
            pstmt.setFloat(6, leave.getDays());
            pstmt.setString(7, leave.getInsNo());
            pstmt.setString(8, leave.getCreateTime());
            pstmt.setString(9, leave.getFlag());
            pstmt.setString(10, leave.getTypes());
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void updaleave(String flag,String stuNo,String startTime) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "update `leave` set flag=? where stuNo=? and startTime=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, flag);
            pstmt.setString(paraIndex++, stuNo);
            pstmt.setString(paraIndex++, startTime);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //审核请假条板块
    public List<leave> auditleave_information(int pageNow, int pageCount, String stuNo) {
        List<leave> leaves = new ArrayList<leave>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT  * from  student  NATURAL JOIN  `leave` NATURAL JOIN instructor  WHERE flag=0 and stuNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + stuNo + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                leave leave = new leave(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                        , rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getFloat(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
                leaves.add(leave);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaves;
    }
    @Override
    public int getTotalRowsauditleave() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = " select count(*) from student  NATURAL JOIN  `leave` NATURAL JOIN instructor where flag=0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    public List<statistics> statistics_information(String clsName,String startTime1,String startTime2){
        List<statistics> statisticss = new ArrayList<statistics>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "select * from student  NATURAL JOIN  `leave` NATURAL JOIN instructor NATURAL JOIN classes WHERE clsName =? and startTime  Between ? And ?  ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clsName);
            pstmt.setString(2, startTime1);
            pstmt.setString(3, startTime2);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                statistics statistics = new statistics(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                        , rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11),
                        rs.getDate(12), rs.getFloat(13), rs.getDate(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18),
                        rs.getString(19),rs.getString(20),rs.getString(21));
                statisticss.add(statistics);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statisticss;
    }

    //导出请假条板块
    public List<leave> daoleave_information(int pageNow, int pageCount, String stuNo) {
        List<leave> leaves = new ArrayList<leave>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT  * from  student  NATURAL JOIN  `leave` NATURAL JOIN instructor  WHERE flag!=3 and stuNo like ?  limit ?,? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + stuNo + "%");
            pstmt.setInt(2, (pageNow - 1) * pageCount);
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                leave leave = new leave(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                        , rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getFloat(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18));
                leaves.add(leave);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return leaves;
    }
    @Override
    public int getTotalRowsdaoleave() {
        DbUtil dbUtil = new DbUtil();
        int count = 0;
        try {
            Connection conn = dbUtil.getConn();
            String sql = " select count(*) from student  NATURAL JOIN  `leave` NATURAL JOIN instructor where flag!=3";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    //权限
    public List<role> role_information() {
        List<role> roles = new ArrayList<role>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT * FROM  roles ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                role role = new role(rs.getString(1), rs.getString(2),rs.getString(3));
                roles.add(role);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public List<meun> meun_information(String id) {
        List<meun> meuns = new ArrayList<meun>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT * FROM menu NATURAL JOIN roles NATURAL JOIN relepower where id= ? ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                meun meun = new meun(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
                rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                meuns.add(meun);

            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meuns;
    }
    public void deletemenu(String id, String psid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            String sql = "delete from relepower  where id=? and psid=?";
            pstmt = conn.prepareStatement(sql);
            int paraIndex = 1;
            pstmt.setString(paraIndex++, id);
            pstmt.setString(paraIndex++, psid);
            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            try {
                throw new SQLException(e);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                dbUtil.close(conn, pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List<meuns> meuns(){
        List<meuns> meunss = new ArrayList<meuns>();
        try {
            Connection conn = dbUtil.getConn();
            String sql = "SELECT * FROM menu  ";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                meuns meuns = new meuns(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5));
                meunss.add(meuns);
            }
            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return meunss;
    }
  public  void addrele(String id,String psid){
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
          conn = dbUtil.getConn();
          String sql = "insert into relepower(id,psid)values(?,?)";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, id);
          pstmt.setString(2 ,psid);
          int i = pstmt.executeUpdate();
      } catch (Exception e) {
          try {
              throw new SQLException(e);
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
      } finally {
          try {
              dbUtil.close(conn, pstmt);
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    }
}