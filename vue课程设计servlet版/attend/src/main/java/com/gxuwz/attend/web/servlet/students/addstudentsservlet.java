package com.gxuwz.attend.web.servlet.students;

import com.gxuwz.attend.entity.Classes;
import com.gxuwz.attend.entity.students;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addstudentsservlet",urlPatterns = {"/api/addstudents"})
public class addstudentsservlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuNo = req.getParameter("stuNo");
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        String clsId = req.getParameter("clsId");
        String stuPwd = req.getParameter("stuPwd");;
        students students = new students(stuNo,stuName,stuSex,clsId,stuPwd);
        leaveservice.addstudents(students);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
