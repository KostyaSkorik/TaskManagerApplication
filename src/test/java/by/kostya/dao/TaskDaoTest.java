package by.kostya.dao;

import by.kostya.entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class TaskDaoTest {

    @Test
    void save() {
        TaskDao taskDao = TaskDao.getInstance();
        Task task = Task.builder()
                .title("testTask")
                .description("testssss")
                .status(Status.COMPLETED)
                .priority(Priority.HIGH)
                .deadlineDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        taskDao.save(task,1L);

    }

}