package by.kostya.dao;

import by.kostya.entity.User;
import by.kostya.utils.HibernateUtil;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {
    private static final UserDao INSTANCE = new UserDao();
    public static UserDao getInstance(){
        return INSTANCE;
    }


    public User save(User user){
        @Cleanup SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        return user;
    }
}
