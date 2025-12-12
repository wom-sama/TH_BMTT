/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_01;

/**
 *
 * @author Administrator
 */
public class AutokeyCipher {
      public String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();

        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char plaintextChar = plaintext.charAt(i);

            if (Character.isLetter(plaintextChar)) {
                char keyChar;

                if (keyIndex < key.length()) {
                    keyChar = key.charAt(keyIndex);
                } else {
                    keyChar = plaintext.charAt(i - key.length());
                }

                int shift = keyChar - 'A';
                char cipheredChar = (char) ((plaintextChar - 'A' + shift) % 26 + 'A');
                ciphertext.append(cipheredChar);
                keyIndex++;
            } else {
                ciphertext.append(plaintextChar);
            }
        }
        return ciphertext.toString();
    }

    public String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();

        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = ciphertext.charAt(i);

            if (Character.isLetter(ciphertextChar)) {
                char keyChar;

                if (keyIndex < key.length()) {
                    keyChar = key.charAt(keyIndex);
                } else {
                    keyChar = ciphertext.charAt(i - key.length());
                }

                int shift = keyChar - 'A';
                char decryptedChar = (char) ((ciphertextChar - 'A' - shift + 26) % 26 + 'A');
                plaintext.append(decryptedChar);
                keyIndex++;
            } else {
                plaintext.append(ciphertextChar);
            }
        }
        return plaintext.toString();
    }
    
}
