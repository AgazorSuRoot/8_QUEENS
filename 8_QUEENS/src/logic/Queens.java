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
	
	
	private static int numSolutions = 0;

	/**
	 * Static function that start the problem ( 8 queens )
	 * @param n number of queens
	 */
	public static StringBuffer eightQueens(int n) {
		numSolutions = 0;
		StringBuffer sol = new StringBuffer();
        int[] a = new int[n];
        eightQueens(a, 0, sol);
        System.out.println(numSolutions);
        
        return sol;
    }
	
	/**
	 * 
	 * @param queens
	 * @param currentRow the row where we are trying to add a queen
	 */
    public static void eightQueens(int[] queens, int currentRow, StringBuffer sol) {
    	int cols = queens.length;
        
        if ( currentRow == cols){
        	sol.append(getStringQueens(queens));
        	numSolutions++;
        	
    	}
        else {
            for (int col = 0; col < cols ; col++) {
              queens[ currentRow ] = col;
              if ( isConsistent(queens,currentRow) ){
            	  eightQueens(queens,currentRow + 1,sol);
              }
            }
        }
    }
   
    public static int[] eightQueensJustOne(int n) {
        int[] a = new int[n];
        eightQueensJustOne(a, 0);
        return a;
    }
    
    public static boolean eightQueensJustOne(int[] queens, int currentRow) {
    	int cols = queens.length;
        
        if ( currentRow == cols){
        	return true;
    	}
        else {
            for (int col = 0; col < cols ; col++) {
              queens[ currentRow ] = col;
              if ( isConsistent(queens,currentRow) ){
            	  if (eightQueensJustOne(queens,currentRow + 1)){
            		  return true;
            	  }
              }
            }
        }
        return false;
    }
    
    /**
     * Print all solutions of the 8-Queens problem.
     * @param q Array with the columns of the queens
     */
    public static StringBuffer getStringQueens(int[] q) {
        StringBuffer sb = new StringBuffer();
    	int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j){ 
                	sb.append("Q ");
            	}else {          
                	sb.append("* ");
                }
            }
            sb.append("\n");
        }  
        sb.append("\n");
        return sb;
    }
}
