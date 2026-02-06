package com.jobportal.api;

import com.jobportal.dao.JobDAO;
import com.jobportal.model.Job;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/jobs")
public class JobApiServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");

        JobDAO dao = new JobDAO();
        List<Job> jobs = dao.getAllJobs();

        StringBuilder json = new StringBuilder();
        json.append("[");

        for(int i=0;i<jobs.size();i++){
            Job j = jobs.get(i);

            json.append("{")
                .append("\"id\":").append(j.getJobId()).append(",")
                .append("\"title\":\"").append(j.getTitle()).append("\",")
                .append("\"company\":\"").append(j.getCompany()).append("\",")
                .append("\"location\":\"").append(j.getLocation()).append("\"")
                .append("}");

            if(i<jobs.size()-1) json.append(",");
        }

        json.append("]");

        resp.getWriter().print(json.toString());
    }
}