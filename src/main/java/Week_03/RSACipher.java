/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_03;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.test.FixedSecureRandom;

/**
 *
 * @author Administrator
 */
public class RSACipher {
    private BigInteger p,q,N,r,E,D;
    private int bitLength;

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public BigInteger getN() {
        return N;
    }

    public void setN(BigInteger N) {
        this.N = N;
    }

    public BigInteger getR() {
        return r;
    }

    public void setR(BigInteger r) {
        this.r = r;
    }

    public BigInteger getE() {
        return E;
    }

    public void setE(BigInteger E) {
        this.E = E;
    }

    public BigInteger getD() {
        return D;
    }

    public void setD(BigInteger D) {
        this.D = D;
    }
    
    public RSACipher(int bitL){
        this.bitLength=bitL;
        generateKeys();
    }
    private void generateKeys(){
        p=BigInteger.probablePrime(bitLength/2, new Random());
        q=BigInteger.probablePrime(bitLength/2, new Random());
        N=p.multiply(q);
        r=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        do {
            E=new BigInteger(bitLength, new Random());
        }while ((E.compareTo(r)!=-1)||(E.gcd(r).compareTo(BigInteger.ONE)!=0));
        D=E.modInverse(r);
    }
    public BigInteger[] encrypt (String mess){
        byte[] bytes =mess.getBytes();
        BigInteger[] encryted = new BigInteger[bytes.length];
        for(int i=0;i<bytes.length;i++){
            encryted[i]=new BigInteger(new byte[]{bytes[i]}).modPow(E, N);
        }
        return encryted;
    }
      public String decrypt (BigInteger[] mess, BigInteger d, BigInteger n){
        byte[] bytes =new byte[mess.length];
        for(int i=0;i<mess.length;i++){
            bytes[i]=mess[i].modPow(d, n).byteValue();
        }
        return new String(bytes);
    }
    
}
