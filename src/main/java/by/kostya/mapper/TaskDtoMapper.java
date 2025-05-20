package by.kostya.mapper;

import by.kostya.dto.TaskDto;
import by.kostya.entity.Task;

public class TaskDtoMapper implements Mapper<TaskDto, Task>{
    @Override
    public Task mapFrom(TaskDto from) {
        return Task.builder()
                .title(from.getTitle())
                .description(from.getDescription())
                .priority(from.getPriority())
                .deadlineDate(from.getDeadline())

                .build();
    }
}
