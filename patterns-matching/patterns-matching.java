//https://www.hackerrank.com/contests/launch-assessment-mock-2-batch-2/challenges/patterns-matching
import java.io.*;
import java.util.*;

public class Solution {
    //this function i have used to check if a token character which isnt needed is present in middle, and also checks if all tokens are present
    public List<Integer> countWithMiddleCases(int count, int j, String x, char arr[])
    {
        List<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
            {
                for(;j<x.length();j++)
                {
                   if(arr[i]==x.charAt(j))
                   {
                       //System.out.println("arr[i]: "+arr[i]);
                       
                       count++;
                       //System.out.println("Inside: "+x.charAt(j)+" "+count);
                       j++;
                       break;
                   }
                   else if(x.charAt(j)>='A'&& x.charAt(j)<='Z')
                   {
                        count=-100;               //count++;
                       //j++;
                       break;
                   }
                }
            }
        output.add(j);
        output.add(count);
        return output;
    }
    //this function i have used to check if a Token is present in String which is extra and after all necessary tokens
    public int endCaseCount(int j, int count, String x)
    {
        for(;j<x.length();j++)
                {
                   if(x.charAt(j)>='A'&& x.charAt(j)<='Z')
                   {
                       count++;
                       //j++;
                       break;
                   }
                }
        return count;
    }
    public boolean isCorrect(String x,char arr[])
    {
         int j=0;
         int count=0;
        boolean output = false;
        List<Integer> list = new ArrayList<Integer>();
        list = countWithMiddleCases(count, j, x, arr);
        j = list.get(0);
        count = list.get(1);
        //System.out.println(list);
            //j=j+1;
           // System.out.println(" "+j+" "+count);  
         count = endCaseCount(j, count, x);   
             if(count==arr.length)
                  output = true;                                          //System.out.println("true");
        return output;
    }

    public static void main(String[] args) {
    
        ArrayList<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
        String temp = sc.nextLine();
        //String finale;
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
                list.add(s);
        }
        
        String finale=sc.nextLine();
        char arr[]= finale.toCharArray();
        //System.out.println(arr);
        Solution s = new Solution();
        
        for(String x:list)
        {
            System.out.println(s.isCorrect(x,arr));
        }
    }
}