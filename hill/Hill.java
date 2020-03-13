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
    
    public static String encripta(String texto, String llave){
        String cifrado;
        int[] keyArr = Alphabet.textToIndex(llave);
        int[] text = Alphabet.textToIndex(texto);
        if(keyArr.length != 4)
            return "La clave debe ser de longitun 4";
        int [][] clave = matrices.matrix(keyArr,2,2);
        int [][] mensaje = matrices.matrix(text,text.length/2,2);
            cifrado = matrices.getCifrado(matrices.multiplicaMatrices(clave, mensaje));
            return cifrado;
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
     */
      String ciff = encripta("CONSUL","HOLA");
      System.out.println(ciff);
     
      int[] det = {-1,-2,2,2};
      int[][] f= matrices.matrix(det, 2, 2);
      double deter = matrices.determinante(f);
      System.out.println(deter);
    
      
      
       
    }
    
}
