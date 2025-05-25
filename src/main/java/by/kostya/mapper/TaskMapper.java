package by.kostya.mapper;

import by.kostya.dto.TaskDto;
import by.kostya.entity.Task;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskMapper implements Mapper<Task, TaskDto> {

    private static final TaskMapper INSTANCE = new TaskMapper();

    public static TaskMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public TaskDto mapFrom(Task from) {
        return TaskDto.builder()
                .title(from.getTitle())
                .description(from.getDescription())
                .priority(from.getPriority())
                .deadline(from.getDeadlineDate())
                .build();
    }
}
