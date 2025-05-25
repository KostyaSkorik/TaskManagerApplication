package by.kostya.service;

import by.kostya.dto.TaskDto;
import org.junit.jupiter.api.Test;


class TaskServiceTest {

    @Test
    void showTasks() {
        TaskService taskService = TaskService.getInstance();

        for(TaskDto taskDto: taskService.showTasks("devKostya")){
            System.out.println(taskDto.getDeadline().getDayOfMonth());
        }
    }
}