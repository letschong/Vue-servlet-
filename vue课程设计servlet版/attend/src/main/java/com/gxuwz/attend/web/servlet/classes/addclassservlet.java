package com.gxuwz.attend.web.servlet.classes;

import com.gxuwz.attend.entity.Classes;
import com.gxuwz.attend.entity.PageBean;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "addclassservlet",urlPatterns = {"/api/addclasses"})
public class addclassservlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clsId = req.getParameter("clsId");
        String clsName = req.getParameter("clsName");
        String clsMajor = req.getParameter("clsMajor");
        String depId = req.getParameter("depId");
        String clsGrade = req.getParameter("clsGrade");
        Classes classes = new Classes(clsId,clsName,clsMajor,depId,clsGrade);
        leaveservice.addclass(classes);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
