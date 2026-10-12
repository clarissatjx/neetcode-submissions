class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        int prev = 0, curr = 0;

        for (int i = 0; i <= (nums1.length + nums2.length)/2; i++) {
            prev = curr;

            if (p1 == nums1.length) {
                curr = nums2[p2++];
            } else if (p2 == nums2.length) {
                curr = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                curr = nums2[p2++];
            } else {
                curr = nums1[p1++];
            }
        }

        return (nums1.length + nums2.length) % 2 == 0
            ? (double) (curr + prev) / 2.0
            : curr;
        
    }

    
}
