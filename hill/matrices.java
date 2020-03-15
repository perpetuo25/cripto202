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
             System.out.print("[" + numeros[j][i] + "]"); //descomentar para ver la matriz resultante
          }
        System.out.println(""); //descomentar para ver la matriz resultante
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
    * Metodo para transformar la matriz a texto
    * @param matrizCifrada
    * @return una cadena cifrada
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
    public static double determinante2x2(int[][] matriz ){
        double deter=matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0];       
        return  deter;
    }
    /**
     * Metodo para calcular la adjunta de una matriz de 2x2
     * @param matriz
     * @return 
     */
    public static int [][] adjunta2x2(int[][] matriz){
       int[][] adj = new int[2][2];
       adj[0][0]= matriz [1][1];
       adj[1][1] = matriz[0][0];
       adj[1][0] = matriz[1][0]*-1;
       adj[0][1] = matriz[0][1]*-1;
       return adj;
    }  
    
    public static double[][] inversa2x2 (int[][]matriz){
         double divDet = 1/determinante2x2(matriz);
         double [][] inv = new double[2][2];
         int[][]adj= adjunta2x2(matriz);
         inv[0][0]= adj[0][0]*divDet;
         inv[0][1]= adj[0][1]*divDet;
         inv[1][0]= adj[1][0]*divDet;
         inv[1][1]= adj[1][1]*divDet;
         for(int j = 0; j < 2; j++){
            for(int i = 0; i < 2; i++){
                System.out.print("[" + inv[j][i] + "]");
            }
           System.out.println(""); 
         }
         return inv;
    
    }
     public static double[][] multiplicaMatricesdo(double[][] matrizClave, int[][] matrizMensaje){
        double[][] mult = new double[matrizMensaje.length][matrizMensaje[0].length];
        
        for(int h=0; h<mult.length;h++){
            for(int i=0; i<matrizClave.length; i++){ 
                double a = 0;
                for(int j=0; j<matrizMensaje[0].length; j++){
                    a = a + (matrizClave[i][j]*matrizMensaje[h][j]);
                    
                }
                mult[h][i] = a; // se saca el modulo 27 de cada elemento de la matriz.
              
            }
            
        }

        return mult;
    }
     public static void imprimeMatriz(double[][]matriz){
         for(int j = 0; j < matriz.length; j++){
            for(int i = 0; i < 2; i++){
                System.out.print("[" + matriz[j][i] + "]");
            }
           System.out.println(""); 
         }
     
     }
     
   }
  
    
    
   

   
   
   

