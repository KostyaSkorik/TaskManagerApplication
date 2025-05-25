package by.kostya.dto;


import by.kostya.entity.Priority;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class TaskDto {
    String title;
    String description;
    Priority priority;
    LocalDateTime deadline;
    //TODO начать хранить тут и статус задачи
}
