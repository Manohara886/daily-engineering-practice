
import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        // Handles subarrays starting from index 0
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            int remaining = sum - k;

            if (map.containsKey(remaining)) {
                int length = i - map.get(remaining);
                maxLength = Math.max(maxLength, length);
            }

            // Store only the first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(longestSubarray(arr, k));
    }
}
