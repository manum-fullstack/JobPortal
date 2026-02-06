package com.jobportal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

/**
 * Servlet implementation class EditJobServlet
 */
@WebServlet("/admin/edit-job")
public class EditJobServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("jobId"));

        JobDAO dao = new JobDAO();
        Job job = dao.getJobById(jobId);

        request.setAttribute("job", job);
        request.getRequestDispatcher("/WEB-INF/admin/edit-job.jsp")
               .forward(request, response);
    }
}