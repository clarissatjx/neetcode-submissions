class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pref = new int[len];
        int[] suf = new int[len];
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                pref[i] = 1;
            } else {
                pref[i] = pref[i - 1] * nums[i - 1];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                suf[i] = 1;
            } else {
                suf[i] = suf[i + 1] * nums[i + 1];
            }
        }

        for (int i = 0; i < len; i++) {
            res[i] = pref[i] * suf[i];
        }

        return res;
        
    }
}  
