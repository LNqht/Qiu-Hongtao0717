package com.qiuhongtao.lab1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "DefaultServlet", value = "/default")
public class DefaultServlet extends HttpServlet {
    public DefaultServlet(){
        System.out.println("I Am from default constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletContext context = getServletContext();
        Integer times = (Integer) context.getAttribute("times");
        if (times == null) {
            times = new Integer(1);
        } else {
            times = new Integer(times.intValue() + 1);
        }
        PrintWriter out= response.getWriter();
        out.println("<html><head><title>");
        out.println("页面访问统计");
        out.println("</title></head><body>");
        out.println("<h1>2020211001000717------QiuHongtao</h1>");
        out.println("Since loading, this servlet has been accessed "+times+" 次");
        out.println("</body></html>");
        context.setAttribute("times",times);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("i am in destroy()");
    }
}
