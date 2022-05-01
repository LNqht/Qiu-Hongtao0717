package com.qiuhongtao.controller;

import com.qiuhongtao.dao.UserDao;
import com.qiuhongtao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static javafx.application.ConditionalFeature.WEB;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")//url
public class UpdateUserServlet extends HttpServlet {
    Connection con =null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //write code
        //TODO 1 : forward to WEB-INF/views/updateUser.jsp
        //TODO 2 : create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update info - can update password, email, gender, birthDate
        con = (Connection) getServletContext().getAttribute("con");
        ///TODO 1: get all(6) request parameters
        //TODO 2: create an object of User Model
        //TODO 3: set all 6 request parameters values into User model - setXXX()
        //TODO 4: create an object of UserDao
        //TODO 5: call updateUser() in UserDao
        //TODO 6: forward to WEB-INF/views/userInfo.jsp
        int id =Integer.parseInt(request.getParameter("id"));//get id <input type="hidden" name="id" />
        String username =request.getParameter("username");//get Username <input type="text" name="username" />
        String password =request.getParameter("password");//get  password <input type="password" name="password" />
        String email =request.getParameter("email");//get <input type="text" name="email" />
        String gender =request.getParameter("gender");//get <input type="radio" name="gender"/>
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));//get Birth Date <input type="text" name="birthDate" />
        User u=new User();
        u.setId(id);
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        u.setGender(gender);
        u.setBirthDate(birthDate);
        HttpSession se=request.getSession();
        se.setMaxInactiveInterval(10);
        se.setAttribute("user",u);
        UserDao dao =new UserDao();
        try{
        dao.updateUser(con,u);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}
