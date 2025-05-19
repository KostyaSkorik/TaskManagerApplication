package by.kostya.dao;

import by.kostya.entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class TaskDaoTest {

    @Test
    void save() {
        TaskDao taskDao = TaskDao.getInstance();
//        User user = User.builder()
//                .username("kostya")
//                .email("kostya@mail.ru")
//                .passwordHash("52HashSaver")
//                .createdAt(LocalDateTime.now())
//                .isActive(true)
//                .role(Role.ADMIN)
//                .build();
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