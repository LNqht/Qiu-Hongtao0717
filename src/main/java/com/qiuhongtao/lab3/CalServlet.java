package com.qiuhongtao.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/lab3/CalServlet")
public class CalServlet extends HttpServlet {
    int result = 0;
    int lenght = 0;
    private int add(int firstVal, int secondVal) {
        return firstVal+secondVal;
    }

    private int subtract(int firstVal, int secondVal) {
        return firstVal-secondVal;
    }

    private int multiply(int firstVal, int secondVal) {
        return firstVal*secondVal;
    }

    private int divide(int firstVal, int secondVal) {
        return firstVal/secondVal;
    }

    private int computeLength(String name) {
        return name.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal = request.getParameter("first")!=""?Integer.parseInt(request.getParameter("first")):0;
        int secondVal = request.getParameter("second")!=""?Integer.parseInt(request.getParameter("second")):0;
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        if(action.equals("Add"))
            result=add(firstVal,secondVal);
        else if(action.equals("Subtract"))
            result=subtract(firstVal,secondVal);
        else if(action.equals("Multiply"))
            result=multiply(firstVal,secondVal);
        else if(action.equals("Divide"))
            result=divide(firstVal,secondVal);
        else if(action.equals("Compute Length"))
            lenght=computeLength(name);
        if(action.equals("Add") || action.equals("Subtract") || action.equals("Multiply") || action.equals("Divide")) {
            Cookie cFirstVal = new Cookie("firstVal",String.valueOf(firstVal));
            Cookie cSecondVal = new Cookie("secondVal",String.valueOf(secondVal));
            Cookie cResult = new Cookie("result",String.valueOf(result));
            cFirstVal.setMaxAge(10);
            cSecondVal.setMaxAge(10);
            cResult.setMaxAge(10);
            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
        }else if(action.equals("Compute Length")){
            Cookie cName = new Cookie("name",name);
            Cookie cLength = new Cookie("length",String.valueOf(lenght));
            cName.setMaxAge(10);
            cLength.setMaxAge(10);
            response.addCookie(cName);
            response.addCookie(cLength);
        }
        response.sendRedirect("cal.jsp");
    }
}
