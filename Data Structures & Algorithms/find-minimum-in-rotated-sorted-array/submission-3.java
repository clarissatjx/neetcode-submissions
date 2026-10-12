class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums.length == 1) return nums[0];

        while (lo <= hi) {
            if (nums[lo] < nums[hi]) return nums[lo];

            int mid = (hi - lo) / 2 + lo;

            if (nums[lo] > nums[lo + 1]) {
                return nums[lo + 1];
            }

            if (nums[lo] > nums[hi]) {
                if (nums[mid] > nums[hi]) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else {
                return nums[lo];
            }
        }

        return Integer.MIN_VALUE;
        
    }
}
