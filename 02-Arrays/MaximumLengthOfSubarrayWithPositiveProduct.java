
public class MaximumLengthOfSubarrayWithPositiveProduct {

    public static int getMaxLen(int[] nums) {

        int posLen = 0;
        int negLen = 0;
        int maxLen = 0;

        for (int num : nums) {

            if (num == 0) {
                // Zero resets both sequences
                posLen = 0;
                negLen = 0;

            } else if (num > 0) {
                // Positive number preserves product signs
                posLen++;

                if (negLen > 0) {
                    negLen++;
                }

            } else {
                // Negative number flips product signs
                int newPos = negLen > 0 ? negLen + 1 : 0;
                int newNeg = posLen + 1;

                posLen = newPos;
                negLen = newNeg;
            }

            maxLen = Math.max(maxLen, posLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, -2, -3, 4};
        int[] nums2 = {0, 1, -2, -3, -4};
        int[] nums3 = {-1, -2, -3, 0, 1};

        System.out.println(getMaxLen(nums1)); // 4
        System.out.println(getMaxLen(nums2)); // 3
        System.out.println(getMaxLen(nums3)); // 2
    }
}

