/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hill;

/**
 *
 * @author ramo_
 */
public class Alphabet {
    /**
     * arreglo con el alfabeto incluyendo la letra Ñ
     */
    static char [] chars = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
    
    /**
     * Metodo para encontrar el indice de un caracter en el alfabetp
     * @param ch el caracter a buscar.
     * @return el indice en el alfabeto.
     */
    public static int findIndex(char ch){  
        int len = chars.length; 
        int i = 0; 
        while (i < len) { 
            if (ch == chars[i]) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    }
    /**
     * Metodo para convertir un texto a indices, de acuerdo al alfabeto.
     * @param text el texto a convertir
     * @return el arreglo de indices de cada letra del texto.
     */
    public static int[] textToIndex(String text){
        char [] splitText = text.toCharArray();
        int[]index = new int[splitText.length];
        for (int i = 0; i < splitText.length; i++){
            index[i] = findIndex(splitText[i]);
        }
        return index;
    }
    /**
     * Metodo para verificar si un numero tiene raiz cuadrada perfecta
     * @param x el numero a verificar
     * @return true si tiene raiz cuadrada entera
     * false en otro caso.
     */
    public static boolean checkPerfectSquare(double x){ 
	double sq = Math.sqrt(x); 
	return ((sq - Math.floor(sq)) == 0); 
    }
    
    public static char[] indexToText(int[] index ){
        char[] text = new char[index.length];
        for (int i = 0; i < index.length; i++){
            text [i]= chars[index[i]];
        }
        return text;
    }
    

}
