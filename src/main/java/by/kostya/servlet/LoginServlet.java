package by.kostya.servlet;

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
                .ifPresentOrElse((userDto) -> onLoginSuccess(req,resp), () -> onLoginFail(req,resp));
    }

    @SneakyThrows
    private void onLoginSuccess(HttpServletRequest req, HttpServletResponse resp) {
//        resp.sendRedirect(req.getContextPath()+URLPath.MANE_PAGE_PATH);
        req.getRequestDispatcher(JSPHelper.getPath("mainPage")).forward(req,resp);
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        req.getRequestDispatcher(JSPHelper.getPath("login")).forward(req,resp);
    }
}
