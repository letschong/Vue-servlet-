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

@WebServlet(name = "adduserservlet",urlPatterns = {"/api/adduser"})
public class adduserservlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("userid");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String depId = req.getParameter("depId");
        String telephone = req.getParameter("telephone");;
        String type = req.getParameter("type");
        user user = new user(userid,fullname,password,depId,telephone,type);
        leaveservice.adduser(user);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
