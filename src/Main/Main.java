package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		List<Problem> listaDeProblemas = new ArrayList<>();
		/*
		int index = 0;
        
     
        int nProblem = Integer.parseInt(args[index++]);

        
       
        for (int i = 0; i < nProblem; i++) {
        
            
            int filas = Integer.parseInt(args[index++]); 
            int columnas = Integer.parseInt(args[index++]); 

            
            int[][] matriz = new int[filas][columnas];

            
            for (int r = 0; r < filas; r++) {
                for (int c = 0; c < columnas; c++) {
                    matriz[r][c] = Integer.parseInt(args[index++]);
                }
            }

            Problem problema = new Problem(matriz);
            
            listaDeProblemas.add(problema);
          
        }
        
        */
		
		int[][] matriz = {
	            {0, 2, 0,21,1},
	            {300, 1, 8,23,45},
	            {11, -1, 13,11,9},
	            {40, 175, 80,25,14}, // Esta es la fila de la mitad (sin -1)
	            {-1, 22, 23,12,11},
	            {26, 27, -12,56},
	            {31, 0, 33,32,7}
	     };
		
		
		
        
        listaDeProblemas.add(new Problem(matriz));
        
        
		
		
        for(Problem problema : listaDeProblemas) {
        	
        	int maximoReliquias = problema.hallarMaximoReliquias();
        	
        	
        }
    }
	
}
