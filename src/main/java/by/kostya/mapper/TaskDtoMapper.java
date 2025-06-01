package by.kostya.mapper;

import by.kostya.dto.TaskDto;
import by.kostya.entity.Task;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskDtoMapper implements Mapper<TaskDto, Task>{
    
    private static final TaskDtoMapper INSTANCE = new TaskDtoMapper();

    public static TaskDtoMapper getInstance() {
        return INSTANCE;
    }
    
    @Override
    public Task mapFrom(TaskDto from) {
        return Task.builder()
                .title(from.getTitle())
                .description(from.getDescription())
                .priority(from.getPriority())
                .deadlineDate(from.getDeadline())
                .status(from.getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
