package com.jobportal.controller;

import com.jobportal.dao.UserDAO;
import com.jobportal.model.User;
import com.jobportal.util.DBUtil;
import com.jobportal.util.PasswordUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    try (Connection con = DBUtil.getConnection()) {

	        PreparedStatement ps = con.prepareStatement(
	            "SELECT user_id, username, password_hash, salt, role FROM users WHERE username = ?"
	        );
	        ps.setString(1, username);

	        ResultSet rs = ps.executeQuery();

	      
	        if (!rs.next()) {
	            response.sendRedirect("login.jsp?error=invalid");
	            return;
	        }

	      
	        String storedHash = rs.getString("password_hash");
	        String salt = rs.getString("salt");
	        String role = rs.getString("role");

	        String inputHash = PasswordUtil.hashPassword(password, salt);

	        // 4️⃣ Compare hashes
	        if (!storedHash.equals(inputHash)) {
	            response.sendRedirect("login.jsp?error=invalid");
	            return;
	        }

	        // ✅ 5️⃣ LOGIN SUCCESS → CREATE SESSION
	        User user = new User();
	        user.setUserId(rs.getInt("user_id"));
	        user.setUsername(rs.getString("username"));
	        user.setRole(role);

	        HttpSession session = request.getSession();
	        session.setAttribute("loggedUser", user);

	        // 6️⃣ Redirect based on role
	        if ("ADMIN".equals(role)) {
	            response.sendRedirect(request.getContextPath()+"/admin/dashboard");
	        } else {
	            response.sendRedirect(request.getContextPath()+ "/user/dashboard");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("login.jsp?error=server");
	    }
	}
}