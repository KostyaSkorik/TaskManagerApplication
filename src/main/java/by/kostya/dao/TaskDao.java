package by.kostya.dao;

import by.kostya.entity.Task;
import by.kostya.entity.User;
import by.kostya.utils.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TaskDao {
    private static final TaskDao INSTANCE = new TaskDao();

    public static TaskDao getInstance() {
        return INSTANCE;
    }

    public Long save(Task task,Long userId){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.find(User.class,userId);
        user.addTask(task);
        session.persist(task);
        session.getTransaction().commit();
        return task.getId();
    }

}
