package com.gxuwz.attend.web.servlet;

import com.alibaba.fastjson.JSON;
import com.gxuwz.attend.web.dto.ApiResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {
    /**
     * 转发请求
     * @param request
     * @param response
     * @param path
     * @throws ServletException
     * @throws IOException
     */
    public void doDispatch(HttpServletRequest request, HttpServletResponse response,String path)throws ServletException, IOException{
        RequestDispatcher dispatcher =request.getRequestDispatcher(path);
        dispatcher.forward(request,response);
    }

    /**
     * 重定向
     * @param request
     * @param response
     * @param url
     * @throws ServletException
     * @throws IOException
     */
    public void doRedirect(HttpServletRequest request, HttpServletResponse response, String url)throws ServletException, IOException{
        response.sendRedirect(url);
    }

    /**
     *
     * @param response
     * @param result
     */
    protected  void write(HttpServletResponse response, ApiResult result)throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        //设置跨域请求共享
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
        response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,Content-Type,Accept");
        String jsonStr=JSON.toJSONString(result);
        response.getWriter().write(jsonStr);
        response.getWriter().flush();
    }
}
