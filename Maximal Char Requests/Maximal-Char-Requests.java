//https://www.hackerrank.com/contests/hack-the-interview-ii-global/challenges/maximal-char-requests/
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
     * Complete the 'getMaxCharCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> getMaxCharCount(String s, List<List<Integer>> queries) {
    // queries is a n x 2 array where queries[i][0] and queries[i][1] represents x[i] and y[i] for the ith query.
        List<Integer> maximums = new ArrayList<>();
         s = s.toLowerCase();
        int[][] maxValue = new int[s.length()][26];
        maxValue[0][(int)s.charAt(0)-97]++;
        char ch;
        for (int i = 1;i < s.length(); i++) {
            ch = s.charAt(i);
            maxValue[i] = maxValue[i-1].clone();
            maxValue[i][(int)ch - 97]++;
        }
        int x,y;
        for (int i = 0;i < queries.size(); i++) {
            x = queries.get(i).get(0);
            y = queries.get(i).get(1);
            for(int j = 25;j >= 0; j--) {
                if(maxValue[y][j] != 0) {
                    if(x==0) {
                        maximums.add(maxValue[y][j]);
                        break;
                    }
                    if(maxValue[y][j] - maxValue[x - 1][j] > 0) {
                        maximums.add(maxValue[y][j] - maxValue[x - 1][j]);
                        break;
                    }
                }
            }
            //maximums.add();
        }
    return maximums;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> query = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                query.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = Result.getMaxCharCount(s, query);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
