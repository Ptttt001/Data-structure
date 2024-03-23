import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java1 {

    public static void main(String[] args) {
        String password = "Peter123"; // 待加密的明文密码
        System.out.println("password:" + password);
        System.out.println("encription:" + encription(password));
        System.out.println("decription:" + verify(password, encription(password)));
    }

    public static String encription(String password) {
        byte[] salt = generateSalt();

        String salt1 = Base64.getEncoder().encodeToString(salt).substring(0, 4);
        String salt2 = Base64.getEncoder().encodeToString(salt).substring(4, 8);
        System.out.println("salt1:" + salt1);
        System.out.println("salt2:" + salt2);
        String saltedPassword = salt1 + password + salt2;

        String hashedPassword = hashPassword(saltedPassword);
        return salt1 + salt2 + hashedPassword;
    }

    public static boolean verify(String password, String hashedPassword) {
        String salt1 = hashedPassword.substring(0, 4);
        String salt2 = hashedPassword.substring(4, 8);
        String saltedPassword = salt1 + password + salt2;
        String hashedPasswordGuess = salt1 + salt2 + hashPassword(saltedPassword);
        return hashedPassword.equals(hashedPasswordGuess);
    }

    // 生成盐值
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[6]; // 盐值的长度可以根据需要调整
        random.nextBytes(salt);
        return salt;
    }

    // 使用SHA-2算法对字符串进行加密
    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
