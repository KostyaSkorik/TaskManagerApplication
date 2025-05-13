package by.kostya.servlet;

import by.kostya.dto.UserDto;
import by.kostya.entity.Role;
import by.kostya.exception.DuplicateException;
import by.kostya.service.UserService;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;

import java.io.IOException;


@WebServlet(URLPath.REGISTRATION_PATH)
public class RegistrationServlet extends HttpServlet {
    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPHelper.getPath("registration")).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = UserDto.builder()
                .username(req.getParameter("username"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role").isBlank() ? "USER":req.getParameter("role")))
                .build();
        System.out.println(userDto);
        if(req.getParameter("role").equals(Role.ADMIN.toString())){
            System.out.println(req.getParameter("secretCode"));
        }
        try {
            userService.creatUser(userDto);
            resp.sendRedirect(req.getContextPath()+URLPath.LOGIN_PATH);
        }catch (ConstraintViolationException | DuplicateException ex){
            req.setAttribute("errors_message",ex.getMessage());
            req.getRequestDispatcher(JSPHelper.getPath("registration")).forward(req, resp);
        }

    }
}
