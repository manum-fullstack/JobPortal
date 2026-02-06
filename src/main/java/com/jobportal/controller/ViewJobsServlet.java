package com.jobportal.controller;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/user/jobs")
public class ViewJobsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JobDAO jobDAO = new JobDAO();
        List<Job> jobs = jobDAO.getAllJobs();

        request.setAttribute("jobs", jobs);
        request.getRequestDispatcher("/WEB-INF/user/jobs.jsp").forward(request, response);
    }
}