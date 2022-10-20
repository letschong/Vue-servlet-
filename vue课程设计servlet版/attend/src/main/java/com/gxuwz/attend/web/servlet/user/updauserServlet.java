package com.gxuwz.attend.web.servlet.user;

import com.gxuwz.attend.entity.students;
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

@WebServlet(name = "updauserServlet",urlPatterns = {"/api/updauser"})
public class updauserServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String depId = request.getParameter("depId");
        String telephone = request.getParameter("telephone");
        String type = request.getParameter("type");
        user user = new user(userid,fullname,password,depId,telephone,type);
        leaveservice.updauser(user);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(response,result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
