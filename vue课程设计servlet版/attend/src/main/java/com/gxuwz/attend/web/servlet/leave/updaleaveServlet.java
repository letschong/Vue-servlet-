package com.gxuwz.attend.web.servlet.leave;

import com.gxuwz.attend.entity.leave;
import com.gxuwz.attend.entity.user;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updaleaveServlet",urlPatterns = {"/api/updaleave"})
public class updaleaveServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuNo = request.getParameter("stuNo");
        String startTime = request.getParameter("startTime");
        String flag= String.valueOf(3);
        leaveservice.updaleave(flag,stuNo,startTime);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
