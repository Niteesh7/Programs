import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String s) {
          
        int count=0;int flag=0;
        char[] number= {'0','1','2','3','4','5','6','7','8','9'};
        char[] l_case= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] u_case= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] s_char= {'!','@','#','$','%','^','&','*','(',')','-','+'};
        
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<number.length;j++) {
                if(s.charAt(i)==number[j]) {
                    j=number.length;i=s.length();flag=0;
                }else { 
                    flag=1;}
            }
        }
        if(flag==1) {
            count++;
            flag=0;
        }
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<l_case.length;j++) {
                if(s.charAt(i)==l_case[j]) {
                    j=l_case.length;i=s.length();flag=0;
                }else { 
                    flag=1;}
            }
        }
        if(flag==1) {
            count++;
            flag=0;
        }
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<u_case.length;j++) {
                if(s.charAt(i)==u_case[j]) {
                    j=u_case.length;i=s.length();flag=0;
                }else { 
                    flag=1;}
            }
        }
        if(flag==1) {
            count++;
            flag=0;
        }
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<s_char.length;j++) {
                if(s.charAt(i)==s_char[j]) {
                    j=s_char.length;i=s.length();flag=0;
                }else { 
                    flag=1;}
            }
        }
        if(flag==1) {
            count++;
            flag=0;
        }
        if(s.length()+count>=6) {
            return count;
        }else {
            int x=(6-(s.length())-count);
            count=count+x;
            return count;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
