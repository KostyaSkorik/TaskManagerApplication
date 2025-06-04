package by.kostya.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.time.LocalDateTime;

@Data
@Builder
@ToString(exclude = "user")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks", schema = "task_manager")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

//    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Priority priority;

    @Column(name = "deadline_date")
    private LocalDateTime deadlineDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    //TODO поменять на LocalDate чтобы не хранить секунды
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
