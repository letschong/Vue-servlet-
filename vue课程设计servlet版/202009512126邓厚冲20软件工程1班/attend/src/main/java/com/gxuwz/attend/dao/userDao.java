package com.gxuwz.attend.dao;

import com.gxuwz.attend.config.DbUtil;
import com.gxuwz.attend.config.StringUtil;
import com.gxuwz.attend.entity.instructor;
import com.gxuwz.attend.entity.students;
import com.gxuwz.attend.entity.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  userDao {
    private DbUtil dbUtil;
    public userDao() {
        this.dbUtil = new DbUtil();
    }


    public List<user> finduser() {
        List<user> users = new ArrayList<user>();
        Connection conn = null;
        String sql = "select * from user ";
        PreparedStatement pstmt = null;
        try {
            conn = dbUtil.getConn();
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user user = new user(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                users.add(user);
            }

            dbUtil.close(conn, pstmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<user> query(user entity) throws Exception {
        List<user> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql = "select * from user where 1=1";
        List<Object>paramValues=new ArrayList<>();
        try {
            if (entity != null) {
                if (entity.getUserid() != null && !"".equals(entity.getUserid().trim())) {
                    sql+= " and userid=?";
                    paramValues.add(entity.getUserid());
                }
                if (entity.getPassword() != null && !"".equals(entity.getPassword().trim())) {
                    sql+= " and password=?";
                    paramValues.add(entity.getPassword());
                }
                }
                if (entity.getDepId() != null && !"".equals(entity.getDepId().trim())) {
                    sql+= " and depId=?";
                    paramValues.add(entity.getDepId());
                }
            if (entity.getTelephone() != null && !"".equals(entity.getTelephone().trim())) {
                sql+= " and telephone=?";
                paramValues.add(entity.getTelephone());
            }
                if (entity.getFullname() != null && !"".equals(entity.getFullname().trim())) {
                    sql+= " and fullname like ?";
                    paramValues.add("%" + entity.getFullname() + "%");
                }
              conn=dbUtil.getConn();
            pstmt=conn.prepareStatement(sql);
            int paraIndex = 1;
            for (Object value:paramValues){
                if(value instanceof  String){
                    pstmt.setString(paraIndex++,(String)value);
                }else if(value instanceof Integer){
                    pstmt.setInt(paraIndex++,(Integer)value);
                }else if(value instanceof Float){
                    pstmt.setFloat(paraIndex++,(Float)value);
                }
            }
            rs=pstmt.executeQuery();
        while (rs.next()){
            String userid=rs.getString("userid");
            String password=rs.getString("password");
            String fullname=rs.getString("fullname");
            String depId=rs.getString("depId");
            String telephone=rs.getString("telephone");
            String type=rs.getString("type");
          user user=new user(userid,fullname,password,depId,telephone,type);
          list.add(user);
        }
     }catch(Exception e) {
            throw new SQLException(e);
        }
        return list;
    }




    //学生
    public List<students> findAllstudents(students example, boolean limit)throws SQLException{
        List<students> list=new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sqlBuff_select=new StringBuffer("select * from student  ");
        StringBuffer sqlBuff_where=new StringBuffer(" where 1=1");
        List<Object> paramValues=new ArrayList<>();
        if(example!=null){
            if(!StringUtil.isEmpty(example.getStuNo())){
                sqlBuff_where.append(" and stuNo =?");
                paramValues.add(example.getStuNo().trim());
            }
            if(!StringUtil.isEmpty(example.getStuPwd())){
                sqlBuff_where.append(" and stuPwd =?");
                paramValues.add(example.getStuPwd().trim());
            }
        }
        if(limit){
            sqlBuff_where.append(" limit 0,2");
        }
        //拼接SQL语句
        String sql =new String(sqlBuff_select.append(sqlBuff_where));
        try{
            conn = dbUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            setPreparedStatement(pstmt,paramValues.toArray());
            rs=pstmt.executeQuery();
            return this.packstudent(rs);
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException(e);
        }finally {
            try {
                dbUtil.close(conn, pstmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<students> packstudent(ResultSet rs)throws SQLException{
        List<students> list=new ArrayList<>();
        while (rs.next()){
            students Student = new students();
            Student.setStuNo(rs.getString("stuNo"));
            Student.setStuName(rs.getString("stuName"));
            Student.setStuSex(rs.getString("stuSex"));
            Student.setClsId(rs.getString("clsId"));
            Student.setStuPwd(rs.getString("stuPwd"));
            list.add(Student);
        }
        return list;
    }


    //辅导员
    public List<instructor> findAllinstructor(instructor example, boolean limit)throws SQLException{
        List<instructor> list=new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sqlBuff_select=new StringBuffer("select * from instructor  ");
        StringBuffer sqlBuff_where=new StringBuffer(" where 1=1");
        List<Object> paramValues=new ArrayList<>();
        if(example!=null){
            if(!StringUtil.isEmpty(example.getInsNo())){
                sqlBuff_where.append(" and insNo =?");
                paramValues.add(example.getInsNo().trim());
            }
            if(!StringUtil.isEmpty(example.getInsPwd())){
                sqlBuff_where.append(" and insPwd =?");
                paramValues.add(example.getInsPwd().trim());
            }
        }
        if(limit){
            sqlBuff_where.append(" limit 0,2");
        }
        //拼接SQL语句
        String sql =new String(sqlBuff_select.append(sqlBuff_where));
        try{
            conn = dbUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            setPreparedStatement(pstmt,paramValues.toArray());
            rs=pstmt.executeQuery();
            return this.packinstructor(rs);
        }catch (Exception e){
            e.printStackTrace();
            throw new SQLException(e);
        }finally {
            try {
                dbUtil.close(conn, pstmt, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<instructor> packinstructor(ResultSet rs)throws SQLException{
        List<instructor> list=new ArrayList<>();
        while (rs.next()){
            instructor instructor = new instructor();
            instructor.setInsNo(rs.getString("insNo"));
            instructor.setInsName(rs.getString("insName"));
            instructor.setDepId(rs.getString("depId"));
            instructor.setInsPwd(rs.getString("insPwd"));
            instructor.setTelephone(rs.getString("telephone"));
            list.add(instructor);
        }
        return list;
    }
    private void setPreparedStatement(PreparedStatement pstmt,Object...params)throws SQLException{
        int parameterIndex=1;
        if(params!=null){
            for(Object x:params){
                if(x instanceof String){
                    pstmt.setString(parameterIndex++,(String)x);
                }
                if(x instanceof Integer){
                    pstmt.setInt(parameterIndex++,(Integer) x);
                }
                if(x instanceof Float){
                    pstmt.setFloat(parameterIndex++,(Float) x);
                }
                if(x instanceof Double){
                    pstmt.setDouble(parameterIndex++,(Double) x);
                }
                if(x instanceof Byte){
                    pstmt.setByte(parameterIndex++,(Byte) x);
                }
                if(x instanceof Short){
                    pstmt.setShort(parameterIndex++,(Short) x);
                }
            }
        }
    }

}