class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < strs.size(); i++) {
            str.append("∞");
            str.append(strs.get(i));
            str.append("π");
        }

        return str.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            if (str.charAt(i) == '∞') {
                StringBuilder s = new StringBuilder();
                i++;
                while (str.charAt(i) != 'π') {
                    s.append(str.charAt(i));
                    i++;
                }
                i++;
                res.add(s.toString());
            } 
        }

        return res;
    }
}
