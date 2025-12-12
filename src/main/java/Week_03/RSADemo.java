/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/**
 *
 * @author Administrator
 */
public class RSADemo {
    public static void main(String[] args) throws IOException {
        int primeSize =1024;
        RSACipher rsa=new RSACipher(primeSize);
        System.out.println("Key Size: "+ primeSize);
        System.out.println();
        System.out.println("Gennerate prime number p and q");
        System.out.println("p: "+rsa.getP().toString(16).toUpperCase());
        System.out.println("p: "+rsa.getQ().toString(16).toUpperCase());
        System.out.println();
        System.out.println("public key");
        System.out.println("p: "+rsa.getN().toString(16).toUpperCase());
        System.out.println("p: "+rsa.getE().toString(16).toUpperCase());
        System.out.println("private key");
        System.out.println("p: "+rsa.getN().toString(16).toUpperCase());
        System.out.println("p: "+rsa.getD().toString(16).toUpperCase());
        System.out.println();
        System.out.println("enter messsage:");
        String plain = new BufferedReader(new InputStreamReader(System.in)).readLine();
        BigInteger[] cipher =rsa.encrypt(plain);
        System.out.print("Cipher text: ");
        for(BigInteger CTB:cipher){
            System.out.print(CTB.toString(16).toUpperCase());
            System.out.print(" ");
        }
         System.out.println();
         String rePLT=rsa.decrypt(cipher, rsa.getD(), rsa.getN());
         System.out.println("Plain text: "+ rePLT);
    }
}
