class Solution {
    public int trap(int[] height) {
        int[] pref = new int[height.length];
        int[] suf = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                pref[i] = 0;
            } else {
                pref[i] = Math.max(pref[i-1], height[i-1]);
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                suf[i] = 0;
            } else {
                suf[i] = Math.max(suf[i+1], height[i+1]);
            }
        }

        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            int vol = (Math.min(pref[i], suf[i]) - height[i]);
            if (vol > 0) {
                ans += vol;
            }
        }

        return ans;
    }
}
