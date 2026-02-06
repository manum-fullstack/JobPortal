package com.jobportal.controller;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;
import com.jobportal.model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/admin/post-job")
public class PostJobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/admin/post-job.jsp")
               .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect(request.getContextPath()+"/unauthorized.jsp");
            return;
        }

        String title = request.getParameter("title");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        String skills=request.getParameter("skills");

        Job job = new Job(0, title, company, location, description,skills, user.getUserId());

        JobDAO jobDAO = new JobDAO();
        jobDAO.addJob(job);

        response.sendRedirect(request.getContextPath()+"/admin/dashboard");
    }
}