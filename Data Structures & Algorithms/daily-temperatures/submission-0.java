class Solution {
    class Helper {
        int idx;
        int val;

        public Helper(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Helper> stack = new ArrayDeque<>();
        int[] days = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            days[i] = 0;
            int temp = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(new Helper(i, temp));
            } else {
                while (!stack.isEmpty() && stack.peek().val < temp) {
                    Helper node = stack.pop();
                    int idx = node.idx;
                    int val = node.val;
                    days[idx] = i - idx;
                }
                stack.push(new Helper(i, temp));
            }
        }

        return days;
        
    }
}
