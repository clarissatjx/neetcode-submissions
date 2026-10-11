class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
        
    }
}
