class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftC = Character.toLowerCase(s.charAt(left));
            char rightC = Character.toLowerCase(s.charAt(right));
            if (isAscii(leftC) && isAscii(rightC) && leftC == rightC) {
                left++;
                right--;
            } else if (isAscii(leftC) && isAscii(rightC)) {
                return false;
            } else {
                if (!isAscii(leftC)) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return true;
        
    }

    public boolean isAscii(char c) {
        return (c >= 'A' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
