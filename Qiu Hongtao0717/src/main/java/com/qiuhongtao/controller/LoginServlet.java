package com.qiuhongtao.controller;

import com.qiuhongtao.dao.UserDao;
import com.qiuhongtao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /// TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        // TODO 2: GET JDBC connection
        //only one one
        con = (Connection) getServletContext().getAttribute("con");
        //check the video live demo#4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request,response);//call dopost
        //when user click Login from menu- method is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        /* TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            //lets change code to make MVC

            //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
            // AND PASSWORD='YYY'
            UserDao userDao = new UserDao();
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                System.out.println("登入成功");
                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                //out.print("Username or password Error!!!");
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp");
            }//end of else



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
