package com.jobportal.dao;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    // ================= POST JOB =================
    public boolean addJob(Job job) {

        String sql = "INSERT INTO jobs (title, company, location, description, skills, posted_by) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompany());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getSkills());
            ps.setInt(6, job.getPostedBy());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= VIEW JOBS =================
    public List<Job> getAllJobs() {

        List<Job> jobs = new ArrayList<>();

        String sql = "SELECT * FROM jobs";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Job job = new Job(
                        rs.getInt("job_id"),
                        rs.getString("title"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getString("skills"),
                        rs.getInt("posted_by")
                );

                jobs.add(job);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobs;
    }

    // ================= CHECK IF USER APPLIED =================
    public boolean hasUserAlreadyApplied(int userId, int jobId) {

        String sql = "SELECT 1 FROM applications WHERE user_id=? AND job_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= APPLY JOB =================
    public void applyJob(int jobId, int userId) {

        String sql = "INSERT INTO applications (user_id, job_id) VALUES (?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DELETE JOB =================
    public void deletejob(int jobId) throws SQLException {

        String sql = "DELETE FROM jobs WHERE job_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);
            ps.executeUpdate();
        }
    }

    // ================= GET JOB BY ID =================
    public Job getJobById(int jobId) {

        Job job = null;

        String sql = "SELECT * FROM jobs WHERE job_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                job = new Job(
                        rs.getInt("job_id"),
                        rs.getString("title"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getString("skills"),
                        rs.getInt("posted_by")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return job;
    }

    // ================= UPDATE JOB =================
    public boolean updateJob(Job job) {

        String sql = "UPDATE jobs SET title=?, company=?, location=?, description=?, skills=? WHERE job_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompany());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getDescription());
            ps.setString(5, job.getSkills());
            ps.setInt(6, job.getJobId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ================= ADMIN VIEW APPLICATIONS =================
    public List<Application> getAllApplications() {

        List<Application> list = new ArrayList<>();

        String sql =
                "SELECT u.username, j.title, j.company, a.status, a.applied_at " +
                "FROM applications a " +
                "JOIN users u ON a.user_id=u.user_id " +
                "JOIN jobs j ON a.job_id=j.job_id";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                list.add(new Application(
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("company"),
                        rs.getString("status"),
                        rs.getString("applied_at")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
 // ================= USER: VIEW MY APPLICATIONS =================
    public List<Application> getApplicationsByUser(int userId) {

        List<Application> list = new ArrayList<>();

        String sql =
            "SELECT j.title, j.company, a.status, a.applied_at " +
            "FROM applications a " +
            "JOIN jobs j ON a.job_id = j.job_id " +
            "WHERE a.user_id = ? " +
            "ORDER BY a.applied_at DESC";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Application(
                    rs.getString("title"),
                    rs.getString("company"),
                    rs.getString("status"),
                    rs.getString("applied_at")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}