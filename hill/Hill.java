/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hill;



/**
 *
 *  @author Eric Sanchez Sarmiento, Fernando Altamirano, Tania 
 */
public class Hill {
    /**
     * Metodo para encriptar un mensaje con clave de longitud 9.
     * @param texto
     * @param llave
     * @return el mensaje cifrado
     */
    public static String encrip3x3(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /3;
        int [][] clave = matrices.matrix(keyArr,3,3);
        //System.out.println("La matriz Clave es:"); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(clave);
        int [][] mensaje = matrices.matrix(text,div,3);
        //System.out.println("La matriz del mensaje es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(mensaje);
            cifrado = matrices.getCifrado2x2(matrices.multiplicaMatrices(clave, mensaje));
            return cifrado;
            
        }
    /**
     * Metodo para encriptar un mensaje con clave de longitud 4.
     * @param texto
     * @param llave
     * @return el mensaje cifrado
     */
    public static String encrip2x2(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /2;
        int [][] clave = matrices.matrix(keyArr,2,2);
        //System.out.println("La matriz Clave es:"); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(clave); //Quitar comentarios para imprimir matrices paso por paso
        double deter = matrices.determinante2x2(clave);
        int [][] mensaje = matrices.matrix(text,div,2);
        //System.out.println("La matriz del mensaje es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(mensaje); //Quitar comentarios para imprimir matrices paso por paso
        if(matrices.MCD((int)deter, 27) ==1){
            cifrado = matrices.getCifrado2x2(matrices.multiplicaMatrices(clave, mensaje));
            return cifrado;
        }
        return "La matriz no es invertible, no se podrá hacer el desencriptado";
        }
    
    
    /**
     * Metodo para encriptar un mensaje, manda a llamar a cualquiera de los metodos de encriptación dependiendo de la longitid 
     * de su clave.
     * @param texto
     * @param llave
     * @return el mensaje cifrado
     */
    public static String encriptaHill(String texto, String llave){
        int[] keyArr = Alphabet.textToIndex(llave);
        
        if(keyArr.length == 9){
            return encrip3x3(texto,llave);
        }else{
            if(keyArr.length == 4)
                return encrip2x2(texto, llave);
    }
        return "La clave debe ser de tamaño 4 o 9";
    }
    /**
     * Metodo para descencriptar un mensaje con clave de longitud 4.
     * @param texto
     * @param llave
     * @return el mensaje descifrado
     */
    public static String desencripta2x2(String texto, String llave){
        int[] keyText = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /2;
        int[][] matll = matrices.matrix(keyText, 2, 2);
        int[][] inver = matrices.inversa2x2(matll);
        //System.out.println("La matriz inversa de la clave es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(inver); //Quitar comentarios para imprimir matrices paso por paso
        int[][] textM = matrices.matrix(text, div, 2);
        //System.out.println("La matriz del mensaje es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(textM); //Quitar comentarios para imprimir matrices paso por paso
        int[][] mult = matrices.multiplicaMatrices(inver, textM);
        //System.out.println("La matriz resultante de la multiplicación es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(mult); //Quitar comentarios para imprimir matrices paso por paso
        String mensaje = matrices.getCifrado2x2(mult);
        return mensaje;
        
    }
     /**
     * Metodo para descencriptar un mensaje con clave de longitud 9.
     * @param texto
     * @param llave
     * @return el mensaje descifrado
     */
            
    public static String desencripta3x3(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /3;
        int [][] claveInv =matrices.inversa3x3(matrices.matrix(keyArr,3,3));
        //System.out.println("La matriz inversa de la clave es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(claveInv); //Quitar comentarios para imprimir matrices paso por paso
        int [][] mensaje = matrices.matrix(text,div,3);
        //System.out.println("La matriz del mensaje es:); //Quitar comentarios para imprimir matrices paso por paso
        //matrices.imprimeMatriz(mensaje); //Quitar comentarios para imprimir matrices paso por paso
            cifrado = matrices.getCifrado2x2(matrices.multiplicaMatrices(claveInv, mensaje));
            return cifrado;
            
        }
      /**
     * Metodo para descencriptar un mensaje, manda a llamar a los metodos de descencriptación
     * segun sea el tamaño de la clave.
     * @param texto
     * @param llave
     * @return el mensaje descifrado
     */
        public static String desencriptaHill (String texto, String llave){
            if(llave.length()==9){
                return desencripta3x3(texto,llave);
            }else{
                return desencripta2x2(texto, llave);
            }
            
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Aquí se imprimen los mensajes
         */
      
      System.out.println("Encriptado de 2x2");
      System.out.println("La Clave es: FEDW\nLa palabra a cifrar es: CONSUL");
      String ciff2x2 = encriptaHill("CONSUL","FEDW"); // AQUI SE LLAMA A LOS METODOS
      System.out.println("La palabra encriptada es: "+ciff2x2+"\n");
      System.out.println("Desencriptado de 2x2");
      System.out.println("La Clave es: FEDW\nLa palabra a desifrar es: PAGQÑS");
      String deciff2x2 = desencriptaHill("PAGQÑS","FEDW"); // AQUI TAMBIEN 
      System.out.println("La palabra desencriptada es: "+deciff2x2+"\n");
      
      
      System.out.println("Ecriptado 3x3");
      System.out.println("La palabra a cifrar es: CONSUL");
      System.out.println("La clave es: FORTALEZA");
      String ciff3x3 = encriptaHill("CONSUL","FORTALEZA");// AQUI 
      System.out.println("La palabra encriptada es "+ciff3x3+"\n");
      System.out.println("Desencriptado 3x3");
      System.out.println("La palabra a descifrar es: KUTÑOB");
      System.out.println("La clave es: FORTALEZA");
      String deciff3x3 =desencripta3x3("KUTÑOB","FORTALEZA");// Y AQUI
      System.out.println("La palabra descencriptada es "+deciff3x3+"\n");
      
      
      
      
      
      
      
      
     
      
      
     
       
      
       
    }
    
}
