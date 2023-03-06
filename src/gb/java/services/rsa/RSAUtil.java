package services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class RSAUtil {

    private final static String PUBLIC_KEY = "src/gb/java/services/public.key";
    private final static String PRIVATE_KEY = "src/gb/java/services/private.key";

    public static void keysCreator() {
        try (FileOutputStream fosPublic = new FileOutputStream(PUBLIC_KEY);
            FileOutputStream fosPrivate = new FileOutputStream(PRIVATE_KEY)){
          
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();

            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            fosPublic.write(publicKey.getEncoded());
            fosPrivate.write(privateKey.getEncoded());
          
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //public void file


  
}
