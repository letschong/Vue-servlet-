package com.gxuwz.attend.service;

import com.gxuwz.attend.dao.userDao;
import com.gxuwz.attend.entity.instructor;
import com.gxuwz.attend.entity.students;
import com.gxuwz.attend.entity.user;

import java.util.List;

public class userservice {
    private userDao userDao;
    public  userservice(){
        this.userDao=new userDao();
    }
public List<user>list(user entity)throws Exception{
        return userDao.query(entity);
}
public  boolean checkUser(String userid,String password)throws Exception{
        boolean flag=false;
        user entity=new user(userid==null?"-110":userid,password);
        List<user> userList=userDao.query(entity);
        flag=userList.isEmpty();
        return !flag;
}

    public user getuser(String userid)throws Exception{
        user entity=new user();
        entity.setUserid(userid==null?"-110":userid);
        List<user> userList=userDao.query(entity);
        if(!userList.isEmpty()){
            return  userList.get(0);
        }else {
            return null;
        }
    }
    public boolean checkStudent(String userid,String password)throws Exception{
        boolean flag = false;
        students example =new students(userid,password);
        List<students> list =userDao.findAllstudents(example,true);
        flag = list.isEmpty();
        return !flag;
    }
    public students getstudent(String userid)throws Exception{
        students example =new students();
        List<students> list =userDao.findAllstudents(example,true);
        if(!list.isEmpty()){
            example= list.get(0);
        }else{
            example= null;
        }
        return example;
    }

    public boolean checkinstructor(String userid,String password)throws Exception{
        boolean flag = false;
        instructor example =new instructor(userid,password);
        List<instructor> list =userDao.findAllinstructor(example,true);
        flag = list.isEmpty();
        return !flag;
    }
    public instructor getinstructor(String userid)throws Exception{
        instructor example =new instructor();
        List<instructor> list =userDao.findAllinstructor(example,true);
        if(!list.isEmpty()){
            example= list.get(0);
        }else{
            example= null;
        }
        return example;
    }

    public List<user> finduser(){
       return userDao.finduser();
    }
}
