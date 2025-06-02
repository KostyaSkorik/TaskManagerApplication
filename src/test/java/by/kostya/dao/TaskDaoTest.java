package by.kostya.dao;

import by.kostya.entity.*;
import by.kostya.utils.FiltersParam;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class TaskDaoTest {

    @Test
    void save() {
        TaskDao taskDao = TaskDao.getInstance();
        Task task = Task.builder()
                .title("testTask")
                .description("testssss")
                .status(Status.NEW)
                .priority(Priority.HIGH)
                .deadlineDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        taskDao.save(task,"devKostya");

    }
    @Test
    void showTaskByUserName(){
        TaskDao taskDao = TaskDao.getInstance();
        String userName = "devKostya";

        System.out.println(taskDao.showTaskByUserName(userName, FiltersParam.builder().build()));

    }

}