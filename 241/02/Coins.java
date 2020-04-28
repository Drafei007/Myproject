package week02;
import java.util.Random;
    /**Public class which returns and prints amount of heads flipped,
    as well as converting coin tosses to a String value (part 1).
    @author Travis. **/
public class Coins{
    /** main method initializing array and testing methods to
    print returned values on a sample array.
    @param args Basis of main statement for application class**/
    public static void main(String[] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        //System.out.println(c.countHeads());
        System.out.println(c.toString());
    }

    /**
     * Returns an int which is the number of runs in this sequence of coins.
     * @return run
     */
    public int  countRuns(){
        int run = 1;
        for (int i = 1; i<coins.length; i++){
            if (coins[i] != coins[i-1]){
                run++;
            }
        }
        return run;     
    }

    /**Declares public data fields as Booleans with assigned true/false
       values and creates a private boolean array, used by other methods.**/
    /**Declares "HEADS"=true.**/  public static final boolean HEADS = true;
    /**Declares "TAILS"=false.**/ public static final boolean TAILS = false;

    private boolean[] coins;
    /**Constructor for coins, instantiates array.
     @param coins Boolean array holding H/T(true/false)**/
    public Coins(boolean[] coins) {
        this.coins = coins;
    }
    /**
     * structs a Coins object  consisting  of  a  series  of length coins – the
     * value of each coin should be determined by a random coin toss.
     * @param lengths 
     */
    public Coins(int lengths){
        boolean toss[] = new boolean[lengths];
        Random random = new Random();
        for (int i = 0; i < toss.length; i++){
            toss[i] = random.nextBoolean();
        }
        coins=toss;
    }
     /**
     * Creates a Coins object from a String consisting entirely of the
     * characters H and T.
     * @param c 
     */
    public Coins (String c){
        this.coins = new boolean[c.length()];
        for (int i = 0; i<coins.length; i++){
            if (c.charAt(i) == 'H'){
                this.coins[i] = HEADS;  
            } else {
                this.coins[i] = TAILS;
            }
        }
    }
    /**Method which add 1 to count for each object in the array,
       (as a Heads flip), and return final count of Heads.
       @return count**/
    public int countHeads(){
        int count = 0;
        for(int i=0; i<coins.length; i++){
            if (coins[i]){
                count++;
            }
        }
        return count;
    }
    /**Method to create empty string, and fill it with H/T representing
       Heads or tails as a coin flip.
       @return output  **/
    public String toString(){
        String output ="";
        for(int i=0;i<coins.length;i++){
            if(coins[i]){
                output+="H";
            } else{
                output+="T";
            }
        }
        return output;
    }
    
}
