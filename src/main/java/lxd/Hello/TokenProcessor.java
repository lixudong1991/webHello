package lxd.Hello;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class TokenProcessor {
    private TokenProcessor() {
    }
    static TokenProcessor instance=null;
    public static TokenProcessor getInstance() {
        if(instance==null) {
            synchronized (TokenProcessor.class) {
                if(instance==null) {
                    instance=new TokenProcessor();
                }
            }
        }
        return instance;
    }
    public String generateToken() {
        String token=System.currentTimeMillis()+new Random().nextInt()+"";
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            byte[] md5=md.digest(token.getBytes());
            BASE64Encoder encoder=new BASE64Encoder();
            return  encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
