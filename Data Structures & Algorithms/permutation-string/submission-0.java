class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(
                s1.charAt(i),
                s1Map.getOrDefault(s1.charAt(i), 0) + 1
            );
        }

        HashMap<Character, Integer> window = new HashMap<>();

        // initialise window
        for (int i = 0; i < s1.length(); i++) {
            window.put(
                s2.charAt(i),
                window.getOrDefault(s2.charAt(i), 0) + 1
            );
        }
        
        if (window.equals(s1Map)) return true;
        int window_size = s1.length();

        for (int i = 1; i < s2.length() - s1.length() + 1; i++) {
            int freq = window.get(s2.charAt(i - 1)) - 1;
            if (freq == 0) {
                window.remove(s2.charAt(i - 1));
            } else {
                window.put(
                    s2.charAt(i - 1),
                    window.get(s2.charAt(i - 1)) - 1
                );
            }
            
            window.put(
                s2.charAt(i + window_size - 1),
                window.getOrDefault(s2.charAt(i + window_size - 1), 0) + 1
            );

            if (window.equals(s1Map)) return true;
        }

        return false;
        
    }
}
