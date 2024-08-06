package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.User;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Create a User object
        User user = new User(name, email);

        // Set the user object in the request scope
        request.setAttribute("user", user);

        // Forward the request to the view (JSP)
        request.getRequestDispatcher("/userView.jsp").forward(request, response);
    }
}
