class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            int freq = map.getOrDefault(s.charAt(r), 0) + 1;
            map.put(s.charAt(r), freq);

            while (r - l + 1 - Collections.max(map.values()) > k) {
                int leftFreq = map.get(s.charAt(l)) - 1;
                map.put(s.charAt(l), leftFreq);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
