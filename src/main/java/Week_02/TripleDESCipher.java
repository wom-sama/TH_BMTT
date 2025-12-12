/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_02;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Administrator
 */
public class TripleDESCipher {
    
     private static final String ALGORITGHM = "DESede";
    private static SecretKey generateKey(String skey)
        throws NoSuchAlgorithmException{
        byte[] keyBytes = skey.getBytes();
        byte[] validKeyBytes= new byte[24];
         for(int i=0;i< validKeyBytes.length;i++){
             if(i<keyBytes.length){
                 validKeyBytes[i]=keyBytes[i];
             }else{
                 validKeyBytes[i]=0;
             }
         }   
         SecretKeySpec keySpec = new SecretKeySpec(validKeyBytes, ALGORITGHM);
         return keySpec;
    }
    
    
     public static String encrypt (String plaintext, String skey)
        throws NoSuchAlgorithmException,
        InvalidKeyException,
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
