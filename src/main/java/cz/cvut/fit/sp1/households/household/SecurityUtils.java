package cz.cvut.fit.sp1.households.household;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class SecurityUtils {

    /**
     * Generates a hash of password, using username as salt
     * @param username Username to use as salt
     * @param password Password to hash
     * @return Hash of the password with username as salt
     */
    public static String getPasswordHash(String username, String password) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), username.getBytes(), 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            return enc.encodeToString(hash);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
