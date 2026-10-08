class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int longest = 0;
        int ans = 0;

        while (right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                longest++;
            }
            ans = Math.max(ans, longest);
            if (right == s.length()) {
                return ans;
            }
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
                longest--;
            }
            set.add(s.charAt(right));
            right++;
            longest++;
            ans = Math.max(ans, longest);
        }

        return ans;
    }
}
