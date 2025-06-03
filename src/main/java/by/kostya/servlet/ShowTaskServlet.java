package by.kostya.servlet;

import by.kostya.dto.UserDto;
import by.kostya.service.TaskService;
import by.kostya.utils.FiltersParam;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(URLPath.SHOW_TASK_PATH)
public class ShowTaskServlet extends HttpServlet {
    private static final TaskService taskService = TaskService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto sessionUser = getUserDto(req);
        FiltersParam filtersParam = FiltersParam.builder()
                .statusFilter("")
                .priorityFilter("")
                .sortedParam("")
                .build();
        req.setAttribute("tasks", taskService.showTasks(sessionUser.getUsername(), filtersParam));
        req.getRequestDispatcher(JSPHelper.getPath("showTask")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FiltersParam filtersParam = FiltersParam.builder()
                .statusFilter(req.getParameter("statusFilter"))
                .priorityFilter(req.getParameter("priorityFilter"))
                .sortedParam(req.getParameter("sortedParam"))
                .build();
        UserDto sessionUser = getUserDto(req);
        req.setAttribute("tasks", taskService.showTasks(sessionUser.getUsername(), filtersParam));
        req.getRequestDispatcher(JSPHelper.getPath("showTask")).forward(req, resp);

    }

    public UserDto getUserDto(HttpServletRequest req) {
        return (UserDto) req.getSession().getAttribute("user");
    }
}

