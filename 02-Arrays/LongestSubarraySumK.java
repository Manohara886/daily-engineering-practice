import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumK {
    public static int longestSubarrayWithSumK(int[] arr, int k) {
        int prefixSum = 0;
        int maxLen = 0;
        Map<Integer, Integer> sumIndices = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If the subarray from index 0 to i has sum k
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // If (prefixSum - k) exists, the subarray after that index has sum k
            if (sumIndices.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - sumIndices.get(prefixSum - k));
            }

            // Only store the earliest index to maximize subarray length
            sumIndices.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int k = 3;
        System.out.println(longestSubarrayWithSumK(arr, k)); // Output: 3
    }
}