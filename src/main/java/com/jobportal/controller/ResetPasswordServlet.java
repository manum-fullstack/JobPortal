package com.jobportal.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.util.DBUtil;
import com.jobportal.util.PasswordUtil;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String username = request.getParameter("username");
    String newPassword = request.getParameter("newPassword");

    try(Connection con = DBUtil.getConnection()){

        String salt = PasswordUtil.generateSalt();
        String hash = PasswordUtil.hashPassword(newPassword, salt);

        PreparedStatement ps = con.prepareStatement(
            "UPDATE users SET password_hash=?, salt=? WHERE username=?"
        );

        ps.setString(1, hash);
        ps.setString(2, salt);
        ps.setString(3, username);

        int rows = ps.executeUpdate();

        if(rows > 0){
            response.sendRedirect("login.jsp?reset=success");
        } else {
            response.sendRedirect("forgot-password.jsp?error=user");
        }

    } catch(Exception e){
        e.printStackTrace();
    }
}
}