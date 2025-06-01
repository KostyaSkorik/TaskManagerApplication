package by.kostya.servlet;

import by.kostya.dto.TaskDto;
import by.kostya.dto.UserDto;
import by.kostya.entity.Priority;
import by.kostya.entity.Status;
import by.kostya.service.TaskService;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;


@WebServlet(URLPath.CREATE_TASK_PATH)
public class CreateTaskServlet extends HttpServlet {
    private static final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPHelper.getPath("createTask")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDto taskDto = TaskDto.builder()
                .title(req.getParameter("title"))
                .description(req.getParameter("description"))
                .priority(Priority.valueOf(req.getParameter("priority")))
                .deadline(LocalDateTime.parse(req.getParameter("deadline_date")))
                .status(Status.NEW)
                .build();
        if(Duration.between(LocalDateTime.now(),taskDto.getDeadline()).toSeconds()<0){
            req.setAttribute("timeError","Invalid Deadline time");
            req.getRequestDispatcher(JSPHelper.getPath("createTask")).forward(req,resp);
        }else {
            req.setAttribute("timeError",null);
            UserDto userDto = (UserDto) req.getSession().getAttribute("user");
            taskService.addTask(taskDto,userDto.getUsername());
            req.getRequestDispatcher(JSPHelper.getPath("mainPage")).forward(req,resp);
            resp.sendRedirect(URLPath.MAIN_PAGE_PATH);
        }
    }
}
