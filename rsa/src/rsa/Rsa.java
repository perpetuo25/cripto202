/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author ramo_
 */
public class Rsa {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //System.out.println( BigInteger.probablePrime(165, new Random()));
      RSACreator rsa = new RSACreator();
      //String teststring = "Gracias Java por los BigIntegers";
      String teststring = "Hola Airym estás bien hermosa";
      System.out.println("Cifrado");     
      System.out.println("El mensjae a cifrar es: " + teststring);
//	// usaremos esto para el desencriptado
      byte[] encrypted = rsa.encriptaByte(teststring.getBytes());              
      System.out.println("El mensjae cifrado en bytes es: "+rsa.encriptaRSA(teststring));
      
      System.out.println("Decifrado");
      byte[] decrypted = rsa.decifra(encrypted);
      System.out.println("Mensaje descifrado en bytes: " +  RSACreator.bytetoString(decrypted));
      System.out.println("Texto decifrado: " + new String(decrypted));
    }
    
        
}
