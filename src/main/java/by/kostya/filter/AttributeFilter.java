package by.kostya.filter;


import by.kostya.entity.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class AttributeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("roles", Role.values());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
