package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Travis Dai
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t is a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && rowValuesIncrease(t) &&
            columnValuesIncrease(t) && isSetOf1toN(t)){
            return true;
        }
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t is a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

     /**
     * A method that returns true if row value is increasing in a array,
      otherwise false.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return ture, if row value is increasing in a array.
     */
    public static boolean rowLengthsDecrease(int[][] t){
        boolean decrease = false;
        int previousLength;

        if ((t.length == 0) || (t.length == 1 && t[0].length == 1)){
            return true;
        }else{
            previousLength = t[0].length;
        }
        
        for (int[] row : t){
            if (row.length <= previousLength){
                decrease = true;
            }else{
                return false;
            }
            previousLength = row.length;
        }
        return decrease;
    }
    
    /**
     * A method that returns true if row value is increasing
 in the array, otherwise false.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return ture, if a no row is longer than a previous row.
     */
    public static boolean rowValuesIncrease(int[][] t){
        int rowValues = t[0][0];
        for (int row = 0; row < t.length; row++){
            for (int col = 0; col < t[row].length; col++){
                if (rowValues > t[row][col]){
                    return false;
                }
                rowValues = t[row][col];
            }
            rowValues = t[row][0];
        }
        return true;
    }

    /**
     * A method that returns true if column value is increasing
 in the array, otherwise false.
     *
     * @param t is a two-dimensional array which represents a tableau.
     *
     * @return ture, if a no column is longer than a previous row.
     */
    public static boolean columnValuesIncrease(int[][] t){
        for (int col = 0; col < t[0].length; col ++){
            for (int row = 0; row < t.length-1; row++){
                if (col < t[row].length && col<t[row+1].length){
                    if (t[row+1][col] < t[row][col]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
     /**
     * A method that returns true if array is a set of 1 to N,
      otherwise false.
     *
     * @param t is a two-dimensional array which represents a tableau.
     *
     * @return ture, if the array is a set of 1 to N.
     */
    public static boolean isSetOf1toN(int[][] t) {

        int count = 0;
        boolean c = false;
        boolean tab = false;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                count++;
                for (int k = 0; k < t.length; k++) {
                    for (int l = 0; l < t[k].length; l++) {
                        if (count == t[k][l] && c) {
                            return false;
                        } else if (count == t[k][l]) {
                            c = true;
                            tab = true;
                        }
                    }
                }
                if (!tab) {
                    return false;
                }
                tab = false;
                c = false;
            }
        }
        return true;
    }
    
}
