class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0 ; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (c1, c2) -> Integer.compare(c2[0], c1[0]));

        int fleet = 0;
        float curr = Float.MAX_VALUE;

        for (int i = 0; i < cars.length; i++) {
            float s = (float) cars[i][1];
            float time = (float) (target - cars[i][0]) / s;
            if (i == 0) {
                fleet++;
                curr = time;
            } else {
                if (time > curr) {
                    curr = time;
                    fleet++;
                }
            }
        }

        return fleet;

        
    }
}
