package by.kostya.dao;

import by.kostya.entity.QUser;
import by.kostya.entity.User;
import by.kostya.exception.DuplicateException;
import by.kostya.utils.HibernateUtil;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {
    private static final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance() {
        return INSTANCE;
    }


    public User save(User user) {
        @Cleanup SessionFactory sessionFactory = HibernateUtil.openSessionFactory();
        @Cleanup ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        if (existsByUsername(sessionFactory, user.getUsername())) {
            throw new DuplicateException("Username already exist");
        }
        if (existsByEmail(sessionFactory, user.getEmail())) {
            throw new DuplicateException("Email already exist");
        }

        Validator validator = validatorFactory.getValidator();
        var validationResult = validator.validate(user);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation error: " + validationResult);
            throw new ConstraintViolationException(validationResult);

        }else {
            @Cleanup Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            return user;
        }
    }

    private boolean existsByUsername(SessionFactory sessionFactory, String username){
        @Cleanup Session session = sessionFactory.openSession();
        return !(new JPAQuery<User>(session).select(QUser.user).from(QUser.user)
                .where(QUser.user.username.eq(username))
                .fetch().isEmpty());
    }
    private boolean existsByEmail(SessionFactory sessionFactory, String email){
        @Cleanup Session session = sessionFactory.openSession();
        return !(new JPAQuery<User>(session).select(QUser.user).from(QUser.user)
                .where(QUser.user.email.eq(email))
                .fetch().isEmpty());
    }
}
