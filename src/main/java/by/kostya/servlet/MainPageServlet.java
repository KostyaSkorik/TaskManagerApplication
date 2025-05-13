package by.kostya.servlet;

import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(URLPath.MAIN_PAGE_PATH)
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPHelper.getPath("mainPage")).forward(req,resp);
    }
}
