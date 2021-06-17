package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/** Servlet responsible for creating new tasks. */
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Sanitize user input to remove HTML tags and JavaScript.
    String emailValue = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String textValue = Jsoup.clean(request.getParameter("emailmessage"), Whitelist.none());
    long timestamp = System.currentTimeMillis();

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Emails");
    FullEntity emailEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("emailaddress", emailValue)
            .set("emailmessage", textValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(emailEntity);

    System.out.println("You submitted: " + emailValue + " " + textValue);
    response.sendRedirect("https://nalemayehu-sps-summer21.appspot.com");
  }
}
