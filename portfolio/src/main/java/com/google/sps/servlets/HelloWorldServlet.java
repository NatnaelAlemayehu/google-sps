package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList; // import the ArrayList class



/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
    response.setContentType("text/html;");
    String[] messages = {"I love eating meat.", " I love drinking wine.", "I love to workout. "};
    String returnjson = getJson(messages);
    
    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(returnjson);
  }

  private String getJson (String[] messages){
    String json = "{";
    json += "\"message\": ";
    json += "[";
    json += "\"" + messages[0] + "\"";
    json += ", ";
    json += "\"" + messages[1] + "\"";
    json += ", ";
    json += "\"" + messages[2] + "\"";  
    json += "]";
    json += "}";
    return json;
  }
}
