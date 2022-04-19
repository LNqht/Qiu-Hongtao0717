package com.qiuhongtao.week2;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {// now its a servlet
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //when a click click the link --- request come here -- GET

    //we want to send Hello to client
    //we need to write hello in response
    PrintWriter out=response.getWriter();
    out.println("Hello Client!!!");
    //thats all

}
}
