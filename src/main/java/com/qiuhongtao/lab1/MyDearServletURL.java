package com.qiuhongtao.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServletURLServlet", value = "/lab1/MyDearServletURL")
public class MyDearServletURL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("<html><head><title>");
        out.println("MyDearServlet");
        out.println("</title></head><body>");
        out.println("<h1>2020211001000717------QiuHongtao</h1>");
        out.println("name:"+request.getParameter("name")+"</br>");
        out.println("class:"+request.getParameter("Class")+"</br>");
        out.println("id:"+request.getParameter("ID")+"</br>");
        out.println("submit:"+request.getParameter("submit")+"</br>");
        out.println("</body></html>");
        // 当action=“MyDearJsp.jsp”时，使用下面的code
        //request.getRequestDispatcher("/lab1/MyDearJsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
