import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        // read from stdin
        Scanner in = new Scanner(System.in);
        int numcars = in.nextInt();
        int[] speeds = new int[numcars];
        for(int i = 0; i<numcars; i++){
            speeds[i] = in.nextInt();
        }
        
        // we have all the info correctly stored
        // now, figure out how to process this
        int groups = 1; // bc have at least one car
        int currspeed = speeds[numcars-1];
        for (int i =numcars-1; i>=0; i--){
            // start from the front i.e. end of array
            if (speeds[i] < currspeed){
                // this car slower than the current speed, 
                // so we need to slow down. therefore, make a new group
                // and reassign the current speed
                groups++;
                currspeed = speeds[i];
            }
        }
        System.out.println(groups);

    }
}