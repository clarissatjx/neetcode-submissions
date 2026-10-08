class Solution {
    public int maxArea(int[] heights) {

        int ans = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int vol = (right - left) * Math.min(heights[left], heights[right]);
            ans = Math.max(ans, vol);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
        
    }
}
