class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int res = nums[0];

        while (lo <= hi) {
            if (nums[lo] < nums[hi]) return Math.min(res, nums[lo]);

            int mid = (hi - lo) / 2 + lo;

            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[lo]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

            
        }

        return res;
        
    }
}
