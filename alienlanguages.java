import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the alienLanguages function below.
     */
    static int alienLanguages(int n, int m) {
        /*
         * Write your code here.
         */
        
        // what we will have to divide by later
        int modfactor = (int)(Math.pow(10, 8)+7);
        
        // this is essentially a tree problem. we have
        // to count the possible valid traversals, 
        // given that we can only go left once (not 2x) in a row
        // and that we have to end on a right
        
        int totalSum = 0;
        
        // first let's calc all the left only sides
        int leftOnlySum = n;
        bool isleft = true;
        for(int i =0; i<m;i++;){
            // go left no more than twice in a row, but always go 
            // left after we go right
            if (isleft){
                isleft = false; // now will MOVE RIGHT
                leftOnlySum*=(n/2-1)
            }
            else{
                isleft = true; // now will MOVE LEFT
                leftOnlySum*=(n/2+1)
            }
        }
        // now done loop so check if we ended on a right
        if(isleft){
            // we ended on a left so no good, change the last 
            // move to a right
            leftOnlySum /=(n/2-1);
            leftOnlySum *=(n/2+1);
        }
        else{
            // we good, add the leftOnlySum to the total sum
            totalSum +=leftOnlySum;
        }
        
        // now let's calc the right only sides
        int rightSum = 0;
        for (int i=0;i<m;i++){
            rightSum*=(n/2+1);
        }
        
        totalSum+=rightSum; // add to our total sum
        
        // now do a combination of both 
        // TO DO: TRANSFORM THIS INTO A RECURSIVE ALGORITHM SO WE CAN DO EVERYTHIG ALTOGETHER
        
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = alienLanguages(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
