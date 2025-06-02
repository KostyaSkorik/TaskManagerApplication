package by.kostya.dao;

import by.kostya.entity.*;
import by.kostya.utils.FiltersParam;
import by.kostya.utils.HibernateUtil;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;

public class TaskDao {
    private static final TaskDao INSTANCE = new TaskDao();

    public static TaskDao getInstance() {
        return INSTANCE;
    }

    public Long save(Task task,String userName){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        JPAQuery<User> jpaQuery = new JPAQuery<>(session);
        session.beginTransaction();
        User user = jpaQuery.select(QUser.user).from(QUser.user).where(QUser.user.username.eq(userName)).fetchOne();
        if(user!=null){
            user.addTask(task);
            session.persist(task);
            session.getTransaction().commit();
            return task.getId();
        }else {
            throw new NullPointerException("User is null");
        }
    }
    public List<Task> showTaskByUserName(String userName, FiltersParam filtersParam){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        QTask qtask = QTask.task;
        JPAQuery<Task> query = new JPAQuery<>(session).select(qtask).from(qtask);
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qtask.user.username.eq(userName));

        if(!filtersParam.getStatusFilter().isEmpty()){
            Status status = Status.valueOf(filtersParam.getStatusFilter());
            booleanBuilder.and(qtask.status.eq(status));
        }
        if(!filtersParam.getPriorityFilter().isEmpty()){
            Priority priority = Priority.valueOf(filtersParam.getPriorityFilter());
            booleanBuilder.and(qtask.priority.eq(priority));
        }

        query.where(booleanBuilder);
        return query.fetch();
    }

    public void update(Long taskId, Priority priority, Status status, LocalDateTime deadLine) {
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        Task task = session.find(Task.class,taskId);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDeadlineDate(deadLine);
        session.flush();
        session.getTransaction().commit();
    }

//    public boolean update (Long taskId, )


}
