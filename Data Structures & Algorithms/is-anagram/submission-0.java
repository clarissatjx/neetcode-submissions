class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int s_count = smap.getOrDefault(s.charAt(i), 0);
            smap.put(s.charAt(i), s_count + 1);

            int t_count = tmap.getOrDefault(t.charAt(i), 0);
            tmap.put(t.charAt(i), t_count + 1);
        }

        return smap.equals(tmap);

    }
}
