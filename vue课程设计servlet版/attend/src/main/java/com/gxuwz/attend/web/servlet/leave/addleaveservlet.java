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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "addleaveservlet",urlPatterns = {"/api/addleave"})
public class addleaveservlet extends BaseServlet {
    ApiResult result = new ApiResult();
   leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuNo = req.getParameter("stuNo");
        String types = req.getParameter("types");
        String reason = req.getParameter("reason");
        String startTime1 = req.getParameter("startTime");
        String endTime1 = req.getParameter("endTime");
        String insNo = req.getParameter("insNo");
        String leaveNo = UUID.randomUUID().toString().replace("-", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date queueDate = new Date();
        String createTime=toForm(queueDate);
        Date date = null;
        try {
            date = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String startTime = toForm(date);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(endTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endTime = toForm(date1);
        float days = Float.parseFloat(String.valueOf((date1.getTime() - date.getTime()) / (24 * 60 * 60 * 1000)));
        String flag= String.valueOf(0);
        leave leave = new leave(leaveNo,reason,startTime,endTime,stuNo,days,insNo,createTime,flag,types);
        leaveservice.addleave(leave);
        result.setCode("200");
        result.setMessage("调用成功");
        this.write(resp,result);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    public static String getSysdateStr3() {

        Date sysdate = new Date();

        return String.format("%tF %tT", sysdate, sysdate);
    }
    public static String toForm(Date date) {


        return String.format("%tF %tT", date,date);   //yyyy-MM-dd HH:mm:ss String.format("%tF %tT", sysdate, sysdate);
    }
}
