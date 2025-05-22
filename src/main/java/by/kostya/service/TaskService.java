package by.kostya.service;

import by.kostya.dao.TaskDao;
import by.kostya.dto.TaskDto;
import by.kostya.entity.Task;
import by.kostya.mapper.TaskDtoMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskService {

    private static final TaskService INSTANCE = new TaskService();

    public static TaskService getInstance() {
        return INSTANCE;
    }

    private final TaskDtoMapper taskDtoMapper = TaskDtoMapper.getInstance();
    private final TaskDao taskDao = TaskDao.getInstance();

    public Long addTask(TaskDto taskDto, String userName) {
        Task task = taskDtoMapper.mapFrom(taskDto);
        return taskDao.save(task,userName);
    }
}
