package com.gxuwz.attend.web.servlet;

import com.gxuwz.attend.entity.user;
import com.gxuwz.attend.service.userservice;
import com.gxuwz.attend.web.dto.ApiResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "userServlet",urlPatterns = {"/api/users"})
public class userServlet extends BaseServlet{
    private userservice userservice;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApiResult apiResult=new ApiResult();
        List user=userservice.finduser();
    }
}
