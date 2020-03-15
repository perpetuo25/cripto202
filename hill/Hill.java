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
    
    public static String encrip3x3(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /3;
        int [][] clave = matrices.matrix(keyArr,3,3);
        int [][] mensaje = matrices.matrix(text,div,3);
            cifrado = matrices.getCifrado(matrices.multiplicaMatrices(clave, mensaje));
            return cifrado;
            
        }
    public static String encrip2x2(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        int div = text.length /2;
        int [][] clave = matrices.matrix(keyArr,2,2);
        int [][] mensaje = matrices.matrix(text,div,2);
            cifrado = matrices.getCifrado(matrices.multiplicaMatrices(clave, mensaje));
            return cifrado;
            
        }
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
       int arreglo[] = {2,15,13,19,21,11};
       int key[]= {5,15,18,20,0,11,4,26,0};
       matrices matr = new matrices();
      int [][] ene = matr.matrix(arreglo,2,3);
      System.out.println("clave");
      int[][] keys = matr.matrix(key,3,3);
      
      int[][] cif = matr.multiplicaMatrices(keys,ene);
      System.out.println(getCifrado(cif));
     
      String ciff = encriptaHill("CONSULTAR","FORTALEZA");
      String ciff2 = encriptaHill("CONSUL","HOLA");
      System.out.println(ciff);
       System.out.println(ciff2);
    
      int[] keyArr = Alphabet.textToIndex("HOLA");
      double[][] mult = matrices.inversa2x2(matrices.matrix(keyArr, 2, 2));
      
      int [][] mensaje = matrices.matrix(Alphabet.textToIndex("WVYIOO"),3,2);
      double[][] rest = matrices.multiplicaMatricesdo(mult, mensaje);
      matrices.imprimeMatriz(rest);
     */
        double x = -143;
        double y = 4295;
        double mod = (x/y) % 27;     
        System.out.println(mod);
      
       
    }
    
}
