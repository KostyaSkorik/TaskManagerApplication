package by.kostya.service;

import by.kostya.dto.TaskDto;
import by.kostya.entity.Task;

public class TaskService {

    private static final TaskService INSTANCE = new TaskService();

    public static TaskService getInstance() {
        return INSTANCE;
    }

//    public Long addTask(TaskDto taskDto) {
//        Task task = taskMapper.
//    }
}
