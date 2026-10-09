class Solution {
    class IntegerPair {
        int index;
        int value;

        public IntegerPair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<IntegerPair> window = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.value, p1.value)); //max heap

        int[] res = new int[nums.length - k + 1];

        // set up window
        for (int i = 0; i < k; i++) {
            IntegerPair ip = new IntegerPair(i, nums[i]);
            window.add(ip);
        }

        res[0] = window.peek().value;

        for (int i = 1; i < nums.length - k + 1; i++) {
            // add next element, get max, remove it if idx < window
            window.add(new IntegerPair(i + k - 1, nums[i + k - 1]));

            while (window.peek().index < i) {
                window.poll();
            }

            res[i] = window.peek().value;
        }

        return res;


    }
}
