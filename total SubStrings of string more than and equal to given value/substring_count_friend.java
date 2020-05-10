import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
//                long check=new BigInteger(sub, 2).longValue();//(sub,2);
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        String s = sc.next();
        String binaryX=Long.toBinaryString(x);
        int binaryXlength = binaryX.length();
        long count=0;
        if(s.length()==binaryXlength)
        {
           long check=new BigInteger(s,2).longValue();
                if(check>=x)
                    count++; 
                    System.out.println(count);
            return ;
        }
        if(x==0)
        {
            count=(n*(n+1))/2;
            System.out.println(count);
            return;
        }
         String sub;
        for(int i=0; i<n; i++)
        {
            
            if(s.charAt(i)=='1')
            {
                int j =i+binaryXlength;
                if(j<=n)
             sub= s.substring(i ,j);
                else
                        { System.out.println(count); 
                        return;
                        }
               // System.out.println("  "+i+"   "+sub);
                long check=new BigInteger(sub, 2).longValue();
                if(check>=x)
                    count++;
               // System.out.println(count);
                long remainString= n-i-1-(j-1-i);
                count+=remainString;//(remainString*(remainString+1))/2;
                                              //  System.out.println(" ll "+count);
            }
            else
            {
               // int j=i+binaryXlength;
                //int r2=s.length()-binaryXlength;
                int tempi;
              int  j=i+1;
                              //  System.out.println("i  "+i+"   ");
                while(j<n)
                {
                    if(s.charAt(j)=='1')
                    {               // System.out.println("inside if");
                        tempi=j;
                        j =tempi+binaryXlength;
                        if(j<=n)
                         sub= s.substring(tempi ,j);
                    
                         else
                        { System.out.println(count); 
                        return;
                        }
                     
                long check=new BigInteger(sub, 2).longValue();
                if(check>=x)
                    count++;
              long remainString= n-tempi-1-(j-1-tempi);
                count+=remainString;//(remainString*(remainString+1))/2;
                break;
                    }
                    j++;
                }
            }
        }
        System.out.println(count);
    }
        
}
