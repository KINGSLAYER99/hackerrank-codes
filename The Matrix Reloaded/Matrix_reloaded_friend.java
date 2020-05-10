import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int _t=0; _t<t; _t++)
        {
        ArrayList<Integer> matrix = new ArrayList<Integer>();
        int n = sc.nextInt();
        n=n*n;
        for(int i=0; i<n; i++)
        {
            matrix.add(sc.nextInt());
            
        }
        //finding the middle no.
        int mid=n/2;
        mid=matrix.get(mid);//mid contains the middle no. now where jumping needs to stop
       // sorting arraylist
        int intial=matrix.get(0);
        Collections.sort(matrix, Collections.reverseOrder());
                                                           // System.out.println(matrix);

        int count=0;
        // if(mid>intial)
        // {
        //     System.out.println(-1);
        //     return;
        // }
        intial= matrix.indexOf(intial);
        int centre = matrix.indexOf(mid);
        if(intial>centre)
            {
            System.out.println(-1);
            continue;
        }
        else
           {
            System.out.println(centre-intial);
        } 
        }
    }
}