/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author ramo_
 */
public class RSACreator {
 private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
   
    
    
    
    
    public  RSACreator() {
		//generamos p y q aleatorios
		p = primos.generaPrimosGrandotes();
		q = primos.generaPrimosGrandotes();
                

		//Se genera n=p*q
		N = p.multiply(q);
		
		
		// phi(n) = (p-1)(q-1) pues p y q obviamente son primos
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		// Entero positivo 'e' menor que phi y que sea coprimo con phi
		e = BigInteger.probablePrime(165/2, new Random());
		
		while ( phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0 ) {
			e.add(BigInteger.ONE);
		}

		// 5. Se determina 'd' que satisfaga la congruencia e*d=1(mod Phi(n))
		d = e.modInverse(phi);
	}
    
   public static String bytetoString(byte[] encrypted) {
		String test = "";
		for (byte b : encrypted) {
			test += Byte.toString(b);
		}
 
		return test;
	}
   
   public byte[] encriptaByte(byte[] message) {
		return (new BigInteger(message)).modPow(e, N).toByteArray();
	}
   
   
   public byte[] decifra(byte[] message) {
		return (new BigInteger(message)).modPow(d, N).toByteArray();
	}
   
   public byte[] textToByte(String mensaje){
   
       return mensaje.getBytes();
   }
  public int tamaño (BigInteger b){
      return b.toString().length();
  }
  
  public String encriptaRSA(String mensaje){
      byte[] mensajebyte = mensaje.getBytes();
      System.out.println("El valor de p es : "+p);
      System.out.println("P tiene "+tamaño(p)+" digitos");
      System.out.println("El valor de q es : "+q);
      System.out.println("Q tiene "+tamaño(q)+" digitos");
      System.out.println("El valor de N es : "+N);
      System.out.println("El valor de Phi es : "+phi);
      System.out.println("El valor de e es : "+e);
      System.out.println("El valor de d es : "+d);
      
      System.out.println("El mensaje en bytes es: "+bytetoString(mensajebyte));
      byte[] encriptByte = encriptaByte(mensajebyte);
      return bytetoString(encriptByte);
  }
}


