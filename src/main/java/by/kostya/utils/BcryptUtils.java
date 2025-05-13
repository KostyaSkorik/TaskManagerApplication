package by.kostya.utils;


import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ResourceBundle;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BcryptUtils {
    private static final ResourceBundle rd = ResourceBundle.getBundle("application");

    public static String generateHash(String password) {
        int salt = Integer.parseInt(rd.getString("application.salt"));
        return BCrypt.hashpw(password, BCrypt.gensalt(salt));
    }
    public static boolean checkPwd(String givenPassword, String DBPassword){
        return BCrypt.checkpw(givenPassword,DBPassword);
    }
}
