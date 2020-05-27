import java.io.*;
import java.util.*;
import java.lang.*;
//find all subsets, calculate for each subset divisible values. to find total numbers from a to b div by p, we use formula b/p - a/p. but here a/p wont be included, hence take a-1/p
public class Numără {
   public int allSubsets(int a, int b, int[] primeArr, int n) {
       int answer = 0;

       for (int i = 1; i < (1 << n); i++) {
           int count = 0;
           int aNew = a - 1;
           int bNew = b;
               for (int j = 0; j < n; j++) {
                   if ((i & (1 << j)) > 0) {
                       count++;
                       aNew /= primeArr[j];
                       bNew /= primeArr[j];
                   }
               }
              // System.out.println("(in else)asnwer before is: " + answer);
               if ((count & 1) != 0) {
                   answer += (bNew - aNew);
               }
               else {
                   answer -= (bNew - aNew);
               }
               //System.out.println("(in else)answer finally is: " + answer);
        }
           //System.out.println();
       return answer;
       }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();
            int  t = sc.nextInt();
            int[] primeArr = new int[k];
            for (int i = 0; i < k; i++) {
                primeArr[i] = sc.nextInt();
            }
            Arrays.sort(primeArr);
            Numără s = new Numără();
           // s.allSubsets(primeArr);

           while(t > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(s.allSubsets(a, b, primeArr, k));
                t--;
            }
        }
}