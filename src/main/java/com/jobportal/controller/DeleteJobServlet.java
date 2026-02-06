package com.jobportal.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.dao.JobDAO;

/**
 * Servlet implementation class DeleteJobServlet
 */
@WebServlet("/admin/delete-job")
public class DeleteJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int jobId = Integer.parseInt(request.getParameter("jobId"));

        JobDAO dao = new JobDAO();
        try {
			dao.deletejob(jobId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect(request.getContextPath()+"/admin/dashboard");
    }
}