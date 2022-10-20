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
import java.util.List;

@WebServlet(name = "sleedituserServlet",urlPatterns = {"/api/sleedituser"})
public class sleedituserServlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid=req.getParameter("userid");
        List<user> user=leaveservice.sleedituser(userid);
        result.setCode("200");
        result.setMessage("调用成功");
        result.setBody(user);
        this.write(resp,result);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
