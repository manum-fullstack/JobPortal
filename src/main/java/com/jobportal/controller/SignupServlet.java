package com.jobportal.controller;
import java.util.*;
import com.jobportal.util.DBUtil;
import com.jobportal.util.PasswordUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection con = DBUtil.getConnection()) {

           
            PreparedStatement check = con.prepareStatement(
                "SELECT user_id FROM users WHERE email = ? OR username = ?"
            );
            check.setString(1, email);
            check.setString(2, username);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                response.sendRedirect("signup.jsp?error=exists");
                return;
            }

           
            String salt = PasswordUtil.generateSalt();
            String hash = PasswordUtil.hashPassword(password, salt);

            // Insert user
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users (username, email, password_hash, salt, role) VALUES (?, ?, ?, ?, 'USER')"
            );

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, hash);
            ps.setString(4, salt);

            ps.executeUpdate();   // ❗ This line was missing

            response.sendRedirect("login.jsp?signup=success");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("signup.jsp?error=db");
        }
    }
}