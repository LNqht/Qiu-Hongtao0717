package com.qiuhongtao.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
//more easy
//1.Tomcat find servlet class -- how ? read web.xml file when?- start tomcat
//2.Load servlet class -- when? 2 ways? way 1- when tomcat start(add code --next class) way2 -when 1st request come in
public class LifeCycleServlet extends HttpServlet {
    //3. call constructor
    public LifeCycleServlet(){
        System.out.println("i am in  LifeCycleServlet()");// when this line print
    }

    //4. call init() -- all servlet have init()-- if u dont write - get from super class

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("i am in init()");// when this line print
    }
//5. call service() - its in super class-- we never write ownself -- > doGet() or doPost()
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");// when this line print
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    //6.this called just before servlet  die

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("i am in destroy()");// when this line print
    }
}
