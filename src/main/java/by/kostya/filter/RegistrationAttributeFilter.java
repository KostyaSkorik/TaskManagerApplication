package by.kostya.filter;


import by.kostya.entity.Role;
import by.kostya.utils.URLPath;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(URLPath.REGISTRATION_PATH)
public class RegistrationAttributeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("roles", Role.values());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
