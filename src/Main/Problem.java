package Main;

public class Problem {

	private int[][] matrizDeTerreno;
	
	private boolean[][] matrizVisita;
	
	Problem(int[][] matrizDeTerreno){
		this.matrizDeTerreno = matrizDeTerreno;
		matrizVisita = new boolean[matrizDeTerreno.length][matrizDeTerreno[0].length];
	}

	public int hallarMaximoReliquias(){
		
		int[][] matrizMax = new int[matrizDeTerreno.length][matrizDeTerreno[0].length];
		
	    int mitad = matrizDeTerreno.length/2;
		
        int CasoIndiana = CasoIndiana(matrizMax, mitad);
        encontrarCaminoMaximo(matrizMax, mitad);
        int CasoMarion = CasoMarion(matrizMax, mitad);
        int CasoSallah = CasoSallah(matrizMax ,mitad);
		
		return CasoIndiana + CasoMarion + CasoSallah;
	}
	
	
	
	

	private int CasoSallah(int[][] matrizMax, int mitad) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int CasoMarion(int[][] matrizMax, int mitad) {
		
		return 0;
	}

	private int CasoIndiana(int[][] matrizMax, int mitad) {
        int p=0;
 
        for(int i=0;i<mitad+1;i++) {
        	for(int j=0;j<p+1;j++) {
        		
        		if(matrizDeTerreno[i][j] == -1) {
        			matrizMax[i][j] = Integer.MIN_VALUE; 
        			
        		}else if(i==0 && j==0) {
        			matrizMax[i][j] = 0;
        			
        		}else if(i==1 && j==0) {
        			matrizMax[i][j] = matrizMax[i-1][j] + matrizDeTerreno[i][j];
        			
        		}else if(i==j) {
        			matrizMax[i][j] = matrizMax[i-1][j-1] + matrizDeTerreno[i][j];
        			
        		}else if(i>1 && j==0) {
        			matrizMax[i][j] = Math.max(matrizMax[i-1][j] + matrizDeTerreno[i][j], matrizMax[i-1][j+1] + matrizDeTerreno[i][j]);
        		
        		}else if(i >0 && j == matrizMax.length-1) {
        			matrizMax[i][j] = Math.max(matrizMax[i-1][j] + matrizDeTerreno[i][j], matrizMax[i-1][j-1] + matrizDeTerreno[i][j]);
        		
        		}else if(i == j+1) {
        			matrizMax[i][j] = Math.max(matrizMax[i-1][j] + matrizDeTerreno[i][j], matrizMax[i-1][j-1] + matrizDeTerreno[i][j]);
        		
        		}else if(i>=1 && j>=1) {
        			matrizMax[i][j] = Math.max(Math.max(matrizMax[i-1][j+1] + matrizDeTerreno[i][j], matrizMax[i-1][j] + matrizDeTerreno[i][j]), matrizMax[i-1][j-1] + matrizDeTerreno[i][j]);
        		}   		
        	}
        	
        	if(p<matrizMax[0].length-1) {
        	  p++;
        	}
        }
        
        for (int i = 0; i < matrizMax.length; i++) {  // Recorre cada fila
            for (int j = 0; j < matrizMax[i].length; j++) {  // Recorre cada columna de la fila actual
                System.out.print(matrizMax[i][j] + " ");  // Imprime el elemento seguido de un espacio
            }
            System.out.println();  // Salto de línea después de imprimir cada fila
        }
		return 0;
	}
	
	 
	private void encontrarCaminoMaximo(int[][] matrizMax, int mitad) {
		 int maxColumna = 0;
	        int maxValor = Integer.MIN_VALUE;

	        // Encontrar el valor máximo en la fila de la mitad
	        for (int j = 0; j < matrizMax[mitad].length; j++) {
	            if (matrizMax[mitad][j] > maxValor) {
	                maxValor = matrizMax[mitad][j];
	                maxColumna = j;
	            }
	        }

	        // Marcar el camino desde la fila mitad hacia arriba
	        for (int i = mitad; i >= 0; i--) {
	            matrizVisita[i][maxColumna] = true;  // Marcar la posición actual como parte del camino

	            if (i > 0) {
	                // Revisamos las tres posibles direcciones para decidir de dónde viene el valor máximo
	                if (maxColumna > 0 && matrizMax[i][maxColumna] == matrizMax[i - 1][maxColumna - 1] + matrizDeTerreno[i][maxColumna]) {
	                    maxColumna--;  // Moverse en diagonal izquierda
	                } else if (maxColumna < matrizMax[i].length - 1 && matrizMax[i][maxColumna] == matrizMax[i - 1][maxColumna + 1] + matrizDeTerreno[i][maxColumna]) {
	                    maxColumna++;  // Moverse en diagonal derecha
	                } 
	                // Si no es diagonal, viene de arriba (mantenerse en la misma columna)
	            }
	        }
	    

    
	        
        for (int i = 0; i < matrizVisita.length; i++) {
            for (int j = 0; j < matrizVisita[i].length; j++) {
                System.out.print(matrizVisita[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
    }
	
}
