class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";
        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            freqMap.put(
                t.charAt(i),
                freqMap.getOrDefault(t.charAt(i), 0) + 1
            );
        }

        
        int have = 0;
        int need = freqMap.size();

        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            window.put(
                s.charAt(r),
                window.getOrDefault(s.charAt(r), 0) + 1
            );
            if (
                freqMap.containsKey(s.charAt(r)) && 
                freqMap.get(s.charAt(r)).equals(window.get(s.charAt(r)))
                ) {
                    have++;
            }

            while (have == need) {
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                window.put(
                    s.charAt(l),
                    window.get(s.charAt(l)) - 1
                );

                if (
                    freqMap.containsKey(s.charAt(l)) &&
                    window.get(s.charAt(l)) < freqMap.get(s.charAt(l))
                    ) {
                        have--;

                }
                l++;
            }

        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
        
    }
}
