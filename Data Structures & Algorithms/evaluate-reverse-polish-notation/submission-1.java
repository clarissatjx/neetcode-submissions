class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+", "-", "*", "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(doOp(b, a, tokens[i]));
                }
                default -> {
                    int number = Integer.parseInt(tokens[i]);
                    stack.push(number);
                }
            }
        }

        return stack.pop();
        
    }

    public int doOp(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
