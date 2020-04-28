package week06;
import java.io.*;
import java.util.Scanner;
/**
 *get the long words and ouput the one over average length.
 *@author Travis
 */
public class LongWords{
    /** this is the maxnumber of the word. **/
    static final int MAX = 100;
    /**
     * the main test is used to output the longwords.
     * @param args is not used.
     *
     * */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int wordLength=0;
        double average=0;
        int wordCount=0;
        String [] words = new String[MAX];
        int sum = 0;
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            Scanner input = new Scanner(line);
            while(input.hasNext() && wordCount<MAX ){
                words[wordCount] = input.next();
                wordCount++;
            }
        }
        for(int i=0;i<wordCount;i++){
            sum += words[i].length();
        }
        if(sum > 0){
            average = (double)sum/wordCount;
            
            for(;wordCount>0;wordCount--){
                if(words[wordCount-1].length()>average){
                    System.out.println(words[wordCount-1]);
                }
            }
            System.out.format("Average: %.2f\n", +average);
        }else{
        }
    }
    
}
