class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(' , '{' , '[' -> stack.push(c);
                case ')' , '}' , ']' -> {
                    if (stack.isEmpty() || stack.pop() != closingBracket(c)) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
        
    }

    public char closingBracket(char c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> 'x';
        };
    }
}
