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
             //System.out.print("[" + numeros[j][i] + "]"); //descomentar para ver la matriz resultante
          }
        //System.out.println(""); //descomentar para ver la matriz resultante
       }
             return numeros;
     }
   
   /**
    * Metodo auxiliar para calcular el modulo de un numero, este metodo es de apoyo para numeros negativos
    * @param number
    * @return el modulo del numero.
    */
   public static int modulo (int number){
      if (number < 0){
         int modul = (number % 27) + 27;
         return modul;
      } 
     return number%27;
       
       
   }
   
   public static double modulod (double number){
      if (number < 0){
         double modul = (number % 27) + 27;
         return modul;
      } 
     return number%27;
       
       
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
                mult[h][i] = modulo(a) ; // se saca el modulo 27 de cada elemento de la matriz.
            }
        }

        return mult;
    }
   /**
    * Metodo para transformar la matriz a texto
    * @param matrizCifrada
    * @return una cadena cifrada
    */
    public static String getCifrado2x2(int[][] matrizCifrada){
        String mesCif = "";
        for(int i=0; i<matrizCifrada.length; i++){
            for(int j=0; j<matrizCifrada[i].length; j++){
                mesCif = mesCif + ( Alphabet.chars[matrizCifrada[i][j]] + "");
            }
        }

        return mesCif;
    }
    /**
     * Método para calcular el inverso modular de un numero
     * @param a
     * @param b
     * @return i si el numero tiene inverso, -1 en caso contrario
     */
     public static int findInverseMult(int a, int b){
        for (int i = 0; i<b; i++){
            if(((i * a) % b) == 1)
                return i;
         //System.out.print(i*a+"  ");
    }
        return -1;
}
    /**
     * Metodo para obtener el determinante de una matriz de 2x2
     * @param matriz la matriz de la que obtenemos el determinante
     * @return 
     */
    public static int determinante2x2(int[][] matriz ){
        int deter=(matriz[0][0]*matriz[1][1])-(matriz[0][1]*matriz[1][0]);
        if(deter <0)
            return (deter % 27) + 27;
        
        return  deter % 27;
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
       //System.out.println("");
       //imprimeMatriz(adj);
       return adj;
    }  
    /**
     * Metodo para generar la matriz inversa de otra matriz
     * @param matriz
     * @return 
     */
    public static int[][] inversa2x2 (int[][]matriz){
       
         int determod = determinante2x2(matriz);
         int inversoMult = findInverseMult(determod,27);
         //System.out.println("");
         //System.out.println(inversoMult);
         int [][] inv = new int[2][2];
         int[][]adj= adjunta2x2(matriz);
         inv[0][0]= modulo(adj[0][0]*inversoMult);
         inv[0][1]= modulo(adj[0][1]*inversoMult);
         inv[1][0]= modulo(adj[1][0]*inversoMult);
         inv[1][1]= modulo(adj[1][1]*inversoMult);
         //for(int j = 0; j < 2; j++){
           // for(int i = 0; i < 2; i++){
             //   System.out.print("[" + inv[j][i] + "]"); // si quieres ver como se imprime la matriz descomenta estas lineas
            //}
           //System.out.println(""); 
         //}
         return inv;
    
    }
   /**
    * Método auxiliar que nos imprime una matriz indicada
    * @param matriz 
    */
     public static void imprimeMatriz(int[][]matriz){
         for(int j = 0; j < matriz.length; j++){
            for(int i = 0; i < 2; i++){
                System.out.print("[" + matriz[j][i] + "]");
            }
           System.out.println(""); 
         }
     
     }
   
    /**
     * Metodo auxiliar para calcular el maximo comun divisor de 2 números
     * @param a
     * @param b
     * @return el mcd de a y b
     */
    public static int MCD (int a, int b) {
        int mcd = 0;
	int r = 0;
	a = Math.abs (a); //Tomamos el valor absoluto
	b = Math.abs (b);
	while (true){
            if (b == 0){
                mcd = a;
		break;
            }else {
		r = a % b;
		a = b;
		b = r;
            }
        }
        return mcd;

    }
    /**
     * Metodo para obtener la inversa de una matriz de 3x3 
     * @param B
     * @return la matriz inversa en mod 27
     */
    public static int[][] inversa3x3(int[][]B){
        int [][]C=new int [3][3];
        int dete,x00,x01,x02,x10,x11,x12,x20,x21,x22;
        dete=((B[0][0]*((B[1][1]*B[2][2])-(B[1][2]*B[2][1])))-(B[0][1]*((B[1][0]*B[2][2])-(B[2][0]*B[1][2])))+(B[0][2]*((B[1][0]*B[2][1])-(B[2][0]*B[1][1]))));
        //System.out.println(dete);
        int determinante = findInverseMult((int)dete,27); 
        //System.out.println(determinante);
        if(determinante!=0){
         x00=(((B[1][1]* B[2][2] - B[2][1]* B[1][2]))*determinante);
         x01=((-(B[1][0]* B[2][2] - B[2][0]* B[1][2]))*determinante);
         x02=((B[1][0]* B[2][1] - B[2][0]* B[1][1]))*determinante;
         x10=(-(B[0][1]* B[2][2] - B[2][1]* B[0][2]))*determinante;
         x11=((B[0][0]* B[2][2] - B[2][0]* B[0][2]))*determinante;
         x12=(-(B[0][0]* B[2][1] - B[2][0]* B[0][1]))*determinante;
         x20=((B[0][1]* B[1][2] - B[1][1]* B[0][2]))*determinante;
         x21=(-(B[0][0]* B[1][2] - B[1][0]* B[0][2]))*determinante;
         x22=((B[0][0]* B[1][1] - B[1][0]* B[0][1] ))*determinante;
            C[0][0]=modulo((int)x00);
            C[0][1]=modulo((int)x10);
            C[0][2]=modulo((int)x20);
            C[1][0]=modulo((int)x01);
            C[1][1]=modulo((int)x11);
            C[1][2]=modulo((int)x21);
            C[2][0]=modulo((int)x02);
            C[2][1]=modulo((int)x12);
            C[2][2]=modulo((int)x22);
             for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    //System.out.print("|"+ C[i][j] +"|");
                }
                //System.out.println();
            } 
            return C;
            
      
            }else{
                return null;
        }
    }

     
   }
  
    
    
   

   
   
   

