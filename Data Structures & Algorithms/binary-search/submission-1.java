class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (hi - lo) / 2 + lo;

        while (lo <= hi) {
            if (lo == hi && nums[lo] == target) return lo;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (hi - lo) / 2 + lo;
        }

        return -1;
        
    }
}
