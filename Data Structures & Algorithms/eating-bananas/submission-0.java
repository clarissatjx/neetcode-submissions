class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > right) right = piles[i];
        }
        int res = right;

        while (left <= right) {
            int k = (left + right) / 2;
            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if (totalTime <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return res;


        
    }
}
