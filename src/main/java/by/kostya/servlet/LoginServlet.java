package by.kostya.servlet;

import by.kostya.dto.UserDto;
import by.kostya.service.UserService;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(URLPath.LOGIN_PATH)
public class LoginServlet extends HttpServlet {

    private static final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPHelper.getPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(req.getParameter("username"),req.getParameter("password"))
                .ifPresentOrElse((userDto) -> onLoginSuccess(userDto,req,resp), () -> onLoginFail(req,resp));
    }

    @SneakyThrows
    private void onLoginSuccess(UserDto userDto, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("user",userDto);
        resp.sendRedirect(req.getContextPath()+URLPath.MAIN_PAGE_PATH);
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("error","Error username or password");
        req.getSession().setAttribute("user",null);
        req.getRequestDispatcher(JSPHelper.getPath("login")).forward(req,resp);
    }
}
