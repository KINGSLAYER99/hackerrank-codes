//to find if given 2 strings, can they be converted to another with 1:1 relationship. ex) abc ->pqr can be converted. abc -> ppp cannot be done, saab -> rrhj is false, ssab -> rrhj is true
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class OneToOne {
    public static void main(String[] args) {
        boolean truth = true;
        HashMap<Character, Character> hash  = new HashMap<>();


        Scanner in = new Scanner(System.in);
        String n = in.next();
        //char[] nArray = n.toCharArray();
        String m = in.next();
        in.close();
        //char[] mArray = m.toCharArray();
        if(n.length() != m.length()) {
            System.out.println("1:1 relationship needs both strings to be of equal length");
        }
        else {
            for (int i = 0; i < n.length();i++) {
                System.out.println("i:"+ i + "  n:" + n.charAt(i) + "  m:" + m.charAt(i));
               // if((hash.get(nArray[i]) == null && hash.get(mArray[i]) == null) || hash.get(nArray[i]) == mArray[i]) {
                if((!hash.containsKey(n.charAt(i)) && !hash.containsValue(m.charAt(i)))) {
                    hash.put(n.charAt(i), m.charAt(i));
                    //hash.put(mArray[i], nArray[i]);
                }
                else if((hash.containsKey(n.charAt(i)) && !hash.containsValue(m.charAt(i)))
                        || (!hash.containsKey(n.charAt(i)) && hash.containsValue(m.charAt(i)))) {
                    truth = false;
                    break;
                }

            }
            System.out.println(hash.keySet());
            System.out.println(hash.values());
            if(!truth) {
                System.out.println(" 1 : 1 relationship can't be maintained");
            }
            else {
                System.out.println("String can be replaced maintaining 1 : 1 relationship");
            }

        }
    }
}