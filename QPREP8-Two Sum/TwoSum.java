import java.io.*;
import java.util.*;

public class TwoSum {
    // Implement your solution by completing the below function	
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2]; 
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
       return result; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = scanner.nextInt();
        int target = scanner.nextInt();
        scanner.close();

        int[] complements = new TwoSum().twoSum(numbers, target);
        System.out.print(complements[0] + " " + complements[1]);
    }
}
