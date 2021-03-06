package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String emailValue = request.getParameter("email");    
    String textValue = request.getParameter("emailmessage");

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + emailValue + " " + textValue);
    response.sendRedirect("https://8080-cs-660787154779-default.cs-europe-west1-itbg.cloudshell.dev/");

    // Write the value to the response so the user can see it.
    //response.getWriter().println("You submitted: " + textValue);
  }
}