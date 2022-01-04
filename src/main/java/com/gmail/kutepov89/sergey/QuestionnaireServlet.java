package com.gmail.kutepov89.sergey;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class QuestionnaireServlet extends HttpServlet {

    static final String TEMPLATE = "<!DOCTYPE html>\n" +
            "<html lang=\"ru\">" +
            "<head><meta charset=\"utf-8\"><title>Result</title></head>" +
            "<body>%s</body></html>";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");
        String html = req.getParameter("html");
        String java = req.getParameter("java");
        String css = req.getParameter("css");
        String msg;

        msg = lastname + " " + firstname + " " + age + " years <p>Skills: ";

        if (html.equals("yes"))
            msg += " HTML";
        if (java.equals("yes"))
            msg += " Java";
        if (css.equals("yes"))
            msg += " CSS";

        msg += "</p>";

        resp.getWriter().println(String.format(TEMPLATE, msg));
    }
}