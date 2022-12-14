package com.gxuwz.attend.web.servlet.leave;

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
import java.util.List;

@WebServlet(name = "statisticsServlet",urlPatterns = {"/api/statistics"})
public class statisticsServlet extends BaseServlet {
    ApiResult result = new ApiResult();
    leaveservice leaveservice = new leaveservieImp();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String clsName = req.getParameter("query");
        String startTime1 = req.getParameter("startTime");
        String startTime2 = req.getParameter("endTime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String startTime = toForm(date);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(startTime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endTime = toForm(date1);
        List statistics=leaveservice.statistics_information(clsName,startTime,endTime);
        result.setCode("200");
        result.setBody(statistics);
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
