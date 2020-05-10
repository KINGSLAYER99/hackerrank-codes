import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long SubString(String str, int n,long x)
    {
        long length = str.length();
        //System.out.println("Length is: "+length);

        long ans=(length*(length+1))/2;
        //System.out.println("ANS ACTUAL IS:"+ans);
        // if(n>1)
        // {
        int l=0,r=1;
        long curr=0;
        while(r<=length && l<length)
        {

            curr = integerfrmbinary(str.substring(l,r));
           // System.out.println("L: "+l+" R: "+r+" Curr: "+curr+" ANSLOOP:"+ans);
            if(l==r)
                return ans;
            if(curr==0 && (r-l)%5001==0) {
                long check=integerfrmbinary(str.substring(l,n));
                if(check<x)
                    break;
            }
            if(curr<x)
                r++;
            else{
                ans=ans-(r-1-l);
                l++;
            }
        }
        //System.out.println("n: "+n+" l: "+l+" r:"+r+" ANSPREV: "+ans);
       // System.out.println(" ANS: "+(((n-l)*(n-l+1))/2));
        ans = ans-(((length-l)*(length-l+1))/2);
        //  }


        return ans;

    }
    public static long integerfrmbinary(String str){
        double j=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== '1'){
                j=j+ Math.pow(2,str.length()-1-i);
            }
        }
        return (long)j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter length:");
        int n = sc.nextInt();
        //System.out.println("Enter Value:");
        long x = sc.nextLong();
       // System.out.println("Enter String:");
        String s = sc.next();
        System.out.println(SubString(s,n,x));

    }
}