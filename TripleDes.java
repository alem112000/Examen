/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3des;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
/**
 *
 * @author Administrador
 */
public class TripleDes {
    public static void main(String args[]){
        byte[] key = "123456781234567812345678".getBytes();
        byte[] data = "alem".getBytes();
        Key deskey = null;
        DESedeKeySpec spec;
        try{
            spec = new DESedeKeySpec(key);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
            deskey = keyfactory.generateSecret(spec);
            
            Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            
            byte [] CipherText = cipher.doFinal(data);
            
            StringBuffer hexCiphertext = new StringBuffer();
            for(int i=0; i<CipherText.length; ++i)
                hexCiphertext.append(Integer.toString((CipherText[i]&0xff)+0x100,16).substring(1));
            
            System.out.println("Ciphertext:" + hexCiphertext);
            
        } catch (InvalidKeyException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(TripleDes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
