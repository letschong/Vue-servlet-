package com.gxuwz.attend.web.servlet.department;

import com.gxuwz.attend.entity.Classes;
import com.gxuwz.attend.entity.PageBean;
import com.gxuwz.attend.entity.department;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "departmentservlet",urlPatterns = {"/api/department"})
public class departmentservlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clsId = req.getParameter("query");
        String pageInfo = req.getParameter("pagenum");
        int pageCount = Integer.parseInt(req.getParameter("pagesize"));
        PageBean<department> pageBean =leaveservice.getTotalRowsdepartment(pageInfo,pageCount,clsId);
        result.setCode("200");
        result.setBody(pageBean);
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
