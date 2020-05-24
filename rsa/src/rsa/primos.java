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
public class primos {
   
    public static BigInteger generaPrimosGrandotes(){
       BigInteger a = BigInteger.probablePrime(165, new Random());
       if (a.isProbablePrime(1) == true){
       return a;
       }
     return generaPrimosGrandotes();
    }
    
}
