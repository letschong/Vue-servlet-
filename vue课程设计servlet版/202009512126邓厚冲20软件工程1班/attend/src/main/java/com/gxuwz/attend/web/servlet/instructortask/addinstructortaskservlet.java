package com.gxuwz.attend.web.servlet.instructortask;

import com.gxuwz.attend.entity.instructor;
import com.gxuwz.attend.entity.instructortask;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addinstructortaskservlet",urlPatterns = {"/api/addinstructortask"})
public class addinstructortaskservlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String insNo = req.getParameter("insNo");
        String clsId = req.getParameter("clsId");
        String startTime = req.getParameter("startTime");
        String startTerm = req.getParameter("startTerm");
        instructortask instructortask = new instructortask(insNo,clsId,startTime,startTerm);
        leaveservice.addinstructortask(instructortask);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
