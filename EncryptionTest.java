/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3des;
 import java.security.InvalidKeyException;
   import java.security.*;
   import javax.crypto.BadPaddingException;
   import javax.crypto.Cipher;
   import javax.crypto.IllegalBlockSizeException;
   import javax.crypto.SecretKey;
   import javax.crypto.SecretKeyFactory;
   import javax.crypto.spec.DESedeKeySpec;
/**
 *
 * @author Administrador
 */
public class EncryptionTest {
    public static void main(String[] args) throws Exception {
        byte[] keyBytes = "123456781234567812345678".getBytes("ASCII");
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
        SecretKey key = factory.generateSecret(keySpec);
        byte[] text = "Hello world".getBytes("ASCII");

        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(text);
        System.out.println(new String(encrypted,"ASCII"));

        cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println(new String(decrypted, "ASCII"));
    }
}