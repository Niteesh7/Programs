import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int a[]=new int[k];
        for(int i=0;i<k;i++)
        {
            a[i]=0;
        }
        for(int i=0;i<s.size();i++)
        {
            int temp=s.get(i);
            a[temp%k]++;
        }
       int count=0;
       if(a[0]>0)
       {
           count++;
       }
       for(int i=1;i<k;i++)
       {
           if(a[i]==0)
           {
               continue;
           }
           if(i+i==k)
           {
               count++;
           }
           else
           {
               if(a[i]>a[k-i])
               {
                   count=count+a[i];
               }
               else
               {
                   count=count+a[k-i];
               }
               a[i]=0;
               a[k-i]=0;
           }
           
       }
    
    
    
    return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
