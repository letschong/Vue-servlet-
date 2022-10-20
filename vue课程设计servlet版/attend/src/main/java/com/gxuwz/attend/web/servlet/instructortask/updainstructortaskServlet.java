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

@WebServlet(name = "updainstructortaskServlet",urlPatterns = {"/api/updainstructortask"})
public class updainstructortaskServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insNo = request.getParameter("insNo");
        String clsId = request.getParameter("clsId");
        String startTime = request.getParameter("startTime");
        String startTerm = request.getParameter("startTerm");
        instructortask instructortask = new instructortask(insNo,clsId,startTime,startTerm);
        leaveservice.updainstructortask(instructortask);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
