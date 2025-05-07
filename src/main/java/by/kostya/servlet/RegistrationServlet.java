package by.kostya.servlet;

import by.kostya.entity.Role;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;


@WebServlet(URLPath.REGISTRATION_PATH)
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Arrays.toString(Role.values()));
        req.setAttribute("roles", Role.values());
        req.getRequestDispatcher(JSPHelper.getPath("registration")).forward(req, resp);
    }

}
