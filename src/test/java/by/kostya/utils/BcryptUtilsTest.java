package by.kostya.utils;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;

class BcryptUtilsTest {

    @Test
    void generateHash() {
        String password = "Anna0203";
        String generated_hash = BcryptUtils.generateHash(password);
        String password_to_verify = "Anna0203";
        Assert.assertTrue(BCrypt.checkpw(password_to_verify,generated_hash));
    }
}