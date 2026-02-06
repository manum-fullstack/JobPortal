package com.jobportal.controller;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Prevent cache
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("loggedUser") : null;

        if (user == null || !"ADMIN".equals(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/error/403.jsp");
            return;
        }

        // ✅ FETCH JOBS
        JobDAO dao = new JobDAO();
        List<Job> jobs = dao.getAllJobs();

        // ✅ SEND TO JSP
        request.setAttribute("jobs", jobs);

        request.getRequestDispatcher("/WEB-INF/admin/dashboard.jsp")
               .forward(request, response);
    }
}