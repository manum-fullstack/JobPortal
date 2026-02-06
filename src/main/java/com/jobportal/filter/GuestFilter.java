package com.jobportal.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import com.jobportal.model.User;

@WebFilter({"/login.jsp", "/signup.jsp"})
public class GuestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (session != null) {
            User user = (User) session.getAttribute("loggedUser");

            if (user != null) {
                // Already logged in → redirect based on role
                if ("ADMIN".equals(user.getRole())) {
                    res.sendRedirect(req.getContextPath() + "/admin/dashboard.jsp");
                } else {
                    res.sendRedirect(req.getContextPath() + "/user/dashboard.jsp");
                }
                return;
            }
        }

        // Not logged in → allow login/signup
        chain.doFilter(request, response);
    }
}