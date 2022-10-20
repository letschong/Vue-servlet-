package com.gxuwz.attend.web.servlet.department;

import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletedepartmentServlet",urlPatterns = {"/api/deletedepartment"})
public class deletedepartmentServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    com.gxuwz.attend.service.leaveservice leaveservice = new leaveservieImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depId = request.getParameter("depId");
        leaveservice.deletedepartment(depId);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
