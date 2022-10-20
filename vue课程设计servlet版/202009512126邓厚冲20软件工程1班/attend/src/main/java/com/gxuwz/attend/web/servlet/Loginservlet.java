package com.gxuwz.attend.web.servlet;

import com.gxuwz.attend.entity.instructor;
import com.gxuwz.attend.entity.students;
import com.gxuwz.attend.entity.user;
import com.gxuwz.attend.service.userservice;
import com.gxuwz.attend.web.dto.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
    @WebServlet(name = "LoginServlet",urlPatterns = {"/api/login"})
public class Loginservlet extends BaseServlet {
    private userservice userservice;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userid=req.getParameter("userid");
       String password=req.getParameter("password");
        System.out.println(userid);
        ApiResult apiResult=new ApiResult();
        try {
            boolean flag=userservice.checkUser(userid,password);
            boolean flag1 = userservice.checkStudent(userid,password);
            boolean flag2 = userservice.checkinstructor(userid,password);
            if(flag){
             apiResult.setCode("200");

             user user=userservice.getuser(userid);
                apiResult.setToken(user.getType());
             apiResult.setBody(user);

            }
            else if(flag1){
                apiResult.setCode("200");
                apiResult.setToken("5");
                students students =userservice.getstudent(userid);
                apiResult.setBody(students);

            }
            else if(flag2){
                apiResult.setCode("200");
                apiResult.setToken("4");
                instructor instructor =userservice.getinstructor(userid);
                apiResult.setBody(instructor);

            }
            else{
                apiResult.setCode("404");
                apiResult.setMessage("找不到userid["+userid+"]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            apiResult.setCode("500");
            apiResult.setMessage("系统内部错误");
        }finally {
         write(resp,apiResult);
        }
    }

    @Override
    public void init() throws ServletException {
        this.userservice=new userservice();
    }
}
