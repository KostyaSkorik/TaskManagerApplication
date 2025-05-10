package by.kostya.utils;


import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BcryptUtils {
    private static final Properties properties = new Properties();

    public static String generateHash(String password) {
        try {
            properties.load(new FileInputStream("application.properties"));
            int salt = Integer.parseInt(properties.getProperty("application.salt"));
            return BCrypt.hashpw(password,BCrypt.gensalt(salt));
        } catch (IOException e) {
            System.out.println("Ошибка чтения propertie файла");
            throw new RuntimeException(e);
        }
    }
}
