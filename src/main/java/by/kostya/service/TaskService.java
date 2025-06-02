package by.kostya.service;

import by.kostya.dao.TaskDao;
import by.kostya.dto.TaskDto;
import by.kostya.entity.Priority;
import by.kostya.entity.Status;
import by.kostya.entity.Task;
import by.kostya.mapper.TaskDtoMapper;
import by.kostya.mapper.TaskMapper;
import by.kostya.utils.FiltersParam;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskService {

    private static final TaskService INSTANCE = new TaskService();

    public static TaskService getInstance() {
        return INSTANCE;
    }

    private final TaskMapper taskMapper = TaskMapper.getInstance();
    private final TaskDtoMapper taskDtoMapper = TaskDtoMapper.getInstance();
    private final TaskDao taskDao = TaskDao.getInstance();

    public Long addTask(TaskDto taskDto, String userName) {
        Task task = taskDtoMapper.mapFrom(taskDto);
        return taskDao.save(task,userName);
    }
    public List<TaskDto> showTasks(String userName, FiltersParam filtersParam){
        return taskDao.showTaskByUserName(userName, filtersParam).stream().map(taskMapper::mapFrom).toList();
    }

    public void update(Long taskId, Priority priority, Status status, LocalDateTime deadLine) {
        taskDao.update(taskId,priority,status,deadLine);
    }
}
