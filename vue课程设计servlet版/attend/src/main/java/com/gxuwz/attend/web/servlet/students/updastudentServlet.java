package com.gxuwz.attend.web.servlet.students;

import com.gxuwz.attend.entity.students;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updastudentServlet",urlPatterns = {"/api/updastudents"})
public class updastudentServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    com.gxuwz.attend.service.leaveservice leaveservice = new leaveservieImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuNo = request.getParameter("stuNo");
        String stuName = request.getParameter("stuName");
        String stuSex = request.getParameter("stuSex");
        String clsId = request.getParameter("clsId");
        String stuPwd = request.getParameter("stuPwd");
        students students = new students(stuNo,stuName,stuSex,clsId,stuPwd);
        leaveservice.updastudents(students);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
