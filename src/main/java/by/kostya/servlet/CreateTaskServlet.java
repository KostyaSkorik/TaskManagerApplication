package by.kostya.servlet;

import by.kostya.dto.TaskDto;
import by.kostya.entity.Priority;
import by.kostya.entity.Status;
import by.kostya.utils.JSPHelper;
import by.kostya.utils.URLPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet(URLPath.CREATE_TASK_PATH)
public class CreateTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("priority", Priority.values());
        req.getRequestDispatcher(JSPHelper.getPath("createTask")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDto taskDto = TaskDto.builder()
                .title(req.getParameter("title"))
                .description(req.getParameter("description"))
                .priority(Priority.valueOf(req.getParameter("priority")))
                .deadline(LocalDateTime.parse(req.getParameter("deadline_date")))
                .build();
        System.out.println(taskDto);
    }
}
