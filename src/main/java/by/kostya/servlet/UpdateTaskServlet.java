package by.kostya.servlet;

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
import java.time.LocalDateTime;


@WebServlet(URLPath.UPDATE_TASK_PATH)
public class UpdateTaskServlet extends HttpServlet {
    private static final TaskService taskService = TaskService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JSPHelper.getPath("updateTask")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Priority priority = Priority.valueOf(req.getParameter("priority"));
        Status status = Status.valueOf(req.getParameter("status"));
        //TODO Сделать валидацию времени
        if(req.getParameter("deadline_date").isEmpty()){
            taskService.update(Long.valueOf(req.getParameter("taskId")),priority,status,null);
        }else {
            LocalDateTime deadLine = LocalDateTime.parse(req.getParameter("deadline_date"));
            taskService.update(Long.valueOf(req.getParameter("taskId")),priority,status,deadLine);
        }
        resp.sendRedirect(req.getContextPath()+URLPath.MAIN_PAGE_PATH);
    }
}
