package com.gxuwz.attend.web.servlet.classes;

import com.gxuwz.attend.entity.Classes;
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

@WebServlet(name = "updaclassesServlet",urlPatterns = {"/api/updaclasses"})
public class updaclassesServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    com.gxuwz.attend.service.leaveservice leaveservice = new leaveservieImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clsId = request.getParameter("clsId");
        String clsName = request.getParameter("clsName");
        String clsMajor = request.getParameter("clsMajor");
        String depId = request.getParameter("depId");
        String clsGrade = request.getParameter("clsGrade");
        Classes classes = new Classes(clsId,clsName,clsMajor,depId,clsGrade);
        System.out.println(classes);
        leaveservice.updaclass(classes);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
