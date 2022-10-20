package com.gxuwz.attend.web.servlet.leave;

import com.gxuwz.attend.entity.PageBean;
import com.gxuwz.attend.entity.instructortask;
import com.gxuwz.attend.entity.leave;
import com.gxuwz.attend.service.leaveservice;
import com.gxuwz.attend.service.leaveservieImp;
import com.gxuwz.attend.web.dto.ApiResult;
import com.gxuwz.attend.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "leaveServlet",urlPatterns = {"/api/leave"})
public class leaveServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuNo = req.getParameter("query");
        String pageInfo = req.getParameter("pagenum");
        int pageCount = Integer.parseInt(req.getParameter("pagesize"));
        String userid = req.getParameter("userid");
        PageBean<leave> pageBean =leaveservice.getTotalRowsleave(pageInfo,pageCount,userid,stuNo);

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
