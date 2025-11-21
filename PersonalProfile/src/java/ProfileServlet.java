/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nurul
 */
@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get all form data
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");

        String favColours = request.getParameter("favColours");
        String favFood = request.getParameter("favFood");
        String hobbies = request.getParameter("hobbies");
        // Get languages as array
        String[] languagesArray = request.getParameterValues("languages");
        String languages = "";
        if (languagesArray != null) {
            languages = String.join(", ", languagesArray);
        }
        String education = request.getParameter("education");
        // Get skills as array to handle multiple selections
        String[] skillsArray = request.getParameterValues("skills");
        String skills = "";
        if (skillsArray != null) {
            skills = String.join(", ", skillsArray);
        }
        String achievement = request.getParameter("achievement");
        String goals = request.getParameter("goals");

        String intro = request.getParameter("intro");

        // Send values to JSP
        request.setAttribute("name", name);
        request.setAttribute("studentId", studentId);
        request.setAttribute("program", program);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("dob", dob);

        request.setAttribute("favColours", favColours);
        request.setAttribute("favFood", favFood);
        request.setAttribute("hobbies", hobbies);
        request.setAttribute("languages", languages);
        request.setAttribute("education", education);
        request.setAttribute("skills", skills);
        request.setAttribute("achievement", achievement);
        request.setAttribute("goals", goals);

        request.setAttribute("intro", intro);

        // Forward to JSP page
        request.getRequestDispatcher("display_profile.jsp").forward(request, response);
    }
}
