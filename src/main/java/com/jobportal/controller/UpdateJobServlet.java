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
 * Servlet implementation class UpdateJobServlet
 */
@WebServlet("/admin/update-job")
public class UpdateJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("jobId"));

        String title = request.getParameter("title");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        String skills = request.getParameter("skills");

        JobDAO dao = new JobDAO();

        // SAFETY: if skills empty, keep existing skills
        if (skills == null || skills.trim().isEmpty()) {
            Job existingJob = dao.getJobById(jobId);
            skills = existingJob.getSkills();
        }

        Job job = new Job(jobId, title, company, location, description, skills, 0);

        dao.updateJob(job);

        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
    }
}