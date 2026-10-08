class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Character>, List<String>> map = new HashMap<>(); 
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            List<Character> list = new ArrayList<>(arr.length);
            for (char c : arr) {
                list.add(c);
            }
            
            if (map.containsKey(list)) {
                List<String> ls = map.get(list);
                ls.add(strs[i]);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(list, ls);
            }
        }

        map.forEach((key, value) -> {
            res.add(value);
        });

        return res;
    }
}
