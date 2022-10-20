package com.gxuwz.attend.web.servlet.students;

import com.gxuwz.attend.entity.Classes;
import com.gxuwz.attend.entity.students;
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

@WebServlet(name = "sleeditstudentsServlet",urlPatterns = {"/api/sleeditstudents"})
public class sleeditstudentsServlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuNo=req.getParameter("stuNo");
        List<students> students=leaveservice.sleeditstudents(stuNo);
        result.setCode("200");
        result.setMessage("调用成功");
        result.setBody(students);
        this.write(resp,result);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
