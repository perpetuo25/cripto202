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
public class matrices {
   
    /**
     * Metodo que crea matrices de tamaño NxM usando un arreglo de enteros
     * @param arr el arreglo de enteros a convertir a matriz
     * @param N filas 
     * @param M columnas
     * @return la matriz de NxM
     */
   public static int[][] matrix(int[] arr, int N,int M) {
       
       int numeros [][] = new int [N][M];
       int contador = 0;
       for(int j = 0; j < N; j++){
         for(int i = 0; i < M; i++){
             numeros[j][i] = arr[contador];
             contador++;
             //System.out.print("[" + numeros[j][i] + "]"); //descomentar para ver la matriz resultante
          }
        //System.out.println(""); //descomentar para ver la matriz resultante
       }
             return numeros;
     }
   /**
    * Metodo para multiplicar matrices
    * @param matrizClave la matriz con la clave, esta debe ser de NxN
    * @param matrizMensaje matriz la matriz con el mensaje, esta debe ser de M x multiplo de N
    * @return la matriz resultante de la multiplicación
    */
   public static int[][] multiplicaMatrices(int[][] matrizClave, int[][] matrizMensaje){
        int[][] mult = new int[matrizMensaje.length][matrizMensaje[0].length];
        
        for(int h=0; h<mult.length;h++){
            for(int i=0; i<matrizClave.length; i++){ 
                int a = 0;
                for(int j=0; j<matrizMensaje[0].length; j++){
                    a = a + (matrizClave[i][j]*matrizMensaje[h][j]);
                }
                mult[h][i] = a % 27; // se saca el modulo 27 de cada elemento de la matriz.
            }
        }

        return mult;
    }
   /**
    * Metodo para transformar la matriz 
    * @param matrizCifrada
    * @return 
    */
    public static String getCifrado(int[][] matrizCifrada){
        String mesCif = "";
        for(int i=0; i<matrizCifrada.length; i++){
            for(int j=0; j<matrizCifrada[i].length; j++){
                mesCif = mesCif + ( Alphabet.chars[matrizCifrada[i][j]] + "");
            }
        }

        return mesCif;
    }
    
    /**
     * Metodo para obtener el determinante de una matriz de 2x2
     * @param matriz la matriz de la que obtenemos el determinante
     * @return 
     */
    public static double determinante(int[][] matriz ){
        double deter=matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0];       
        return  deter;
    }
   
   
    
    
       
   }
  
    
    
   

   
   
   

