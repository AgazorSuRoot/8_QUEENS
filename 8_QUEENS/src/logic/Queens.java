package logic;

public class Queens {
	
	/**
	 * 
	 * @param queens Array with the columns of the queens
	 * @param rows the number of queens that existed before adding the new one
	 * @return boolean true if the movement is legal or false if not
	 */
	public static boolean isConsistent(int[] queens, int rows) {
        int beforeColumn, currentColumn = queens[rows];
		for (int row = 0; row < rows ; row++) {
        	beforeColumn = queens[ row ];
        	
        	if ( beforeColumn == currentColumn){
        		return false;
        	}
        	
        	// y = mx + n  m = 1 --> \
        	if ( (rows - row ) == (currentColumn - beforeColumn) ){
        		return false;
        	}
        	
        	// y = mx + n  m = -1 --> /
        	if ( (rows - row )  == (beforeColumn - currentColumn) ){
        		return false;
        	}
        	
        }
        return true;
    }
	
	static int contador = 0;
	/**
	 * Static function that start the problem ( 8 queens )
	 * @param n number of queens
	 */
	public static void eightQueens(int n) {
		contador = 0;
        int[] a = new int[n];
        eightQueens(a, 0);
        System.out.println(contador);
    }
	
	/**
	 * 
	 * @param queens
	 * @param currentRow the row where we are trying to add a queen
	 */
    public static void eightQueens(int[] queens, int currentRow) {
    	int cols = queens.length;
        
        if ( currentRow == cols){
        	printQueens(queens);
        	contador++;
    	}
        else {
            for (int col = 0; col < cols ; col++) {
              queens[ currentRow ] = col;
              if ( isConsistent(queens,currentRow) ){
            	  eightQueens(queens,currentRow + 1);
              }
            }
        }
    }
   
    /**
     * Print all solutions of the 8-Queens problem.
     * @param q Array with the columns of the queens
     */
    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) 
                	System.out.print("Q ");
                else           
                	System.out.print("* ");
            }
            System.out.println();
        }  
        System.out.println();
    }
    
    public static void main(String[] args){
    	eightQueens(8);
    }
}
