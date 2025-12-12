/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_02;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
/**
 *
 * @author Administrator
 */
public class DESCipher {
    private static final String ALGORITGHM = "DES";
    private static SecretKey generateKey(String skey)
        throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException{
        DESKeySpec keySpec = new DESKeySpec(skey.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITGHM);
        return keyFactory.generateSecret(keySpec);    
    }
    
    public static String encrypt (String plaintext, String skey)
        throws NoSuchAlgorithmException,
        InvalidKeyException,
        InvalidKeySpecException,
        NoSuchPaddingException,
        BadPaddingException,
        IllegalBlockSizeException{
        SecretKey key =generateKey(skey);
        Cipher cipher =Cipher.getInstance(ALGORITGHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);   
    }
    
    public static String decrypt (String ciphertext,String skey ) 
            throws NoSuchAlgorithmException, 
                   InvalidKeyException,
                   InvalidKeySpecException,
                   NoSuchPaddingException,
                   BadPaddingException,
                   IllegalBlockSizeException {
        
        SecretKey key = generateKey(skey);
        Cipher cipher = Cipher.getInstance(ALGORITGHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodeBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptBytes = cipher.doFinal(decodeBytes);
        return new String(decryptBytes);
    }
}
