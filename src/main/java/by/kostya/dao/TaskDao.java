package by.kostya.dao;

import by.kostya.entity.QTask;
import by.kostya.entity.QUser;
import by.kostya.entity.Task;
import by.kostya.entity.User;
import by.kostya.utils.HibernateUtil;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    public List<Task> showTaskByUserName(String userName){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        return new JPAQuery<Task>(session).select(QTask.task).from(QTask.task).where(QTask.task.user.username.eq(userName)).fetch();

    }

}
