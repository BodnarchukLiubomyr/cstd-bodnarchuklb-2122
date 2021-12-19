package com.company.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if("active".equals(req.getServletContext().getAttribute("active"))){
            ((HttpServletResponse) resp).sendRedirect("/internet_provider/home");
        }
        chain.doFilter(req, resp);
    }
}
