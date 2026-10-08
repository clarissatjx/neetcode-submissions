class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); 
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedS = new String(arr);
           
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(strs[i]);
        }

        map.forEach((key, value) -> {
            res.add(value);
        });

        return res;
    }
}
