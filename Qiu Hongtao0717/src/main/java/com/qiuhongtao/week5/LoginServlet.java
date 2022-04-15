package com.qiuhongtao.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con=null;
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
    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
    // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        try {

        //lets change code to make MVC

        //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
        // AND PASSWORD='YYY'
        String sql="select id,username,password,email,gender,birthdate from usertable where username='"+username+"' and password='"+password+"'";

            ResultSet rs =con.createStatement().executeQuery(sql);
            if (rs.next()){
                //week 5 code
                //out.print("Login Successful!!!");
                //out.print("Welcome"+username);
                //get from rs and set into resquest attribute

                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthdate"));
                //forward to userInfo.jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else{
              //out.print("Username or password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }//end of else


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
