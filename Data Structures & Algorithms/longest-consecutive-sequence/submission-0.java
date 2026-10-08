class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int seen = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                seen++;
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] -  1 == nums[i - 1]) {
                seen++;
            } else {
                ans = Math.max(ans, seen);
                seen = 1;
            }
        }

        return Math.max(ans, seen);
        
    }
}
