package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Application;
import com.jobportal.model.User;

@WebServlet("/user/applications")
public class MyApplicationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        JobDAO jobDAO = new JobDAO();
        List<Application> apps = jobDAO.getApplicationsByUser(user.getUserId());

        request.setAttribute("applications", apps);

        request.getRequestDispatcher("/WEB-INF/user/applications.jsp")
               .forward(request, response);
    }}



