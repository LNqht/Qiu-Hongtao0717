package com.qiuhongtao.week5;



import com.qiuhongtao.dao.UserDao;
import com.qiuhongtao.model.User;

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



        //week7 - mvc - we write jdbc code in DAO . user model

        UserDao userDao=new UserDao();
        User user=(User) null;
        try {
            user=userDao.findByUsernamePassword(con,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(user!=null){
            //valid
            //week 8 code
            //add code for remember me
            String rememberMe=request.getParameter("rememberMe");//1=checked, null if  checked
            if(rememberMe!=null && rememberMe.equals("1")){
                //want to remember me
                //create 3 cookies
                Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                //set age of cookies
                usernameCookie.setMaxAge(5);
                passwordCookie.setMaxAge(5);
                rememberMeCookie.setMaxAge(5);
                //add 3 cookies into response
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(rememberMeCookie);

            }


            //valid-- login
            //week 8 code - demo #1-use cookie for session
            //create cookie
            //step 1:create an object of cookie class
            //Cookie c=new Cookie("sessionid",""+user.getId());
            //step 2:set age of cookie
            //c.setMaxAge(10*60);
            //step 3:add cookie response
            //response.addCookie(c);
            //week 8 code
            //create a session
            HttpSession session=request.getSession();
            //check session id
            System.out.println("session id-->"+session.getId());
            //set time for session
            session.setMaxInactiveInterval(10);//for 5 10 section if request not come in - tomcat kill session - set 60*60 == 1h

            //set user model into reuqest
            //week 8- change request(one page) to session - so we can get session attribute in many jsp page and header

            session.setAttribute("user",user);//set user info in session
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            //forward
        }else{
            //invalid
            request.setAttribute("message","Username or Password ERROR!!!");
            //forward
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
        }



        //lets change code to make MVC

        //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
        // AND PASSWORD='YYY'
        /*String sql="select id,username,password,email,gender,birthdate from usertable where username='"+username+"' and password='"+password+"'";
try{
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
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else{
              //out.print("Username or password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);

            }//end of else


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    }
}
