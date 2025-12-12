/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_01;

/**
 *
 * @author Administrator
 */
public class VigenereCipher {
    private static String vigCipher(String text, String key, boolean enc){
        StringBuilder result = new StringBuilder();
        key=key.toLowerCase();
        int keyLen=key.length();
        int keyIdx=0;
        for (char character : text.toCharArray()){
            if(Character.isLetter(character)){
                char base = Character.isUpperCase(character)? 'A':'a';
                int shift = key.charAt(keyIdx% keyLen)-'a';
                if (!enc){
                    shift=26-shift;
                }
                result.append((char)((character-base+shift)%26+base));
                keyIdx++;
            }else{
                result.append(character);
            }
        }
        return result.toString();
    }
    
    public static String encrypt(String text, String key){
        return vigCipher(text, key, true);
    }
    
    public static String decrypt(String text, String key){
        return vigCipher(text, key, false);
    }
}
