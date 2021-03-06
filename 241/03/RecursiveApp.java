package week03;
/**
 * A application that counts the numbers and sum of the numbers in a long.
 *
 *@author travis
 */
public class RecursiveApp{
 /**
 * returns a long equal to the number of digits of its argument.
 * @param n is a long.
 * @return a number equal to the length of digits.
 */
    public static long digits(long n){
        if (n<10) {
            return 1;
        }else {
            return( 1 + (digits(n/10)));
        }
    }
/**
*returns a long equal to the sum of the digits of n.
*@return long equal to sum of digits.
*@param n is a long.
*/
    public static long sumOfDigits(long n){
    
        if (n==0){
            return 0;
        }else{
            return n%10+ sumOfDigits(n/10);
        }
    }
}

