package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sort_Array_By_Parity_905 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            int[] ret = new Sort_Array_By_Parity_905().sortArrayByParity(A);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int idx = n - 1;
        for (int i = 0; i < n && i < idx; i++) {
            while ((A[i] & 1) == 1 && i < n && i < idx) {
                if (A[idx] % 2 == 0) {
                    swap(A,i,idx);
                }else {
                    idx--;
                }
            }
        }
        return A;
    }

    public void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}