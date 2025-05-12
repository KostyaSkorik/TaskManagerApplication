package by.kostya.utils;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUtil {

    public static SessionFactory openSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            return configuration.buildSessionFactory();
        }catch (Throwable ex){
            System.out.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
