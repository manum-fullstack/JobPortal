package com.jobportal.controller;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Application;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/applications")
public class ViewApplicationsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JobDAO dao = new JobDAO();
        List<Application> list = dao.getAllApplications();

        request.setAttribute("applications", list);
        request.getRequestDispatcher("/WEB-INF/admin/applications.jsp").forward(request, response);
    }
}