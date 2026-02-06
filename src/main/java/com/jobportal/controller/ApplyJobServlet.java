package com.jobportal.controller;

import com.jobportal.util.DBUtil;
import com.jobportal.dao.JobDAO;
import com.jobportal.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/apply-job")
public class ApplyJobServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("loggedUser");

        String jobIdStr = request.getParameter("jobId");

        if (jobIdStr == null || jobIdStr.isEmpty()) {
            response.sendRedirect(request.getContextPath() +"/user/jobs?=error=invalid_job");
            return;
        }

        int jobId = Integer.parseInt(jobIdStr);

        JobDAO dao = new JobDAO();

        if (dao.hasUserAlreadyApplied(user.getUserId(), jobId)) {
            response.sendRedirect(request.getContextPath() + "/user/dashboard?error=already_applied");
            return;
        }

        dao.applyJob(jobId, user.getUserId());

        response.sendRedirect(request.getContextPath() + "/user/dashboard?success=true");
    }

}