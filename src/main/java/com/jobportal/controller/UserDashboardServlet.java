package com.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

@WebServlet("/user/dashboard")
public class UserDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        if (user == null || !"USER".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // ✅ FETCH JOBS
        JobDAO jobDAO = new JobDAO();
        List<Job> jobs = jobDAO.getAllJobs();

        // ✅ SEND TO JSP
        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/WEB-INF/user/dashboard.jsp")
               .forward(request, response);
    }
}