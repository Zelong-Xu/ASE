package MathPlot;

import java.util.Stack;

public class RPNBuilder implements ExpressionBuilder {

    @Override
    public Expr build(String input) {

        Stack<Expr> stack = new Stack<>();

        String[] tokens = input.split(" ");

        for (String token : tokens) {

            if (token.isEmpty()) continue;

            token = token.toLowerCase();

            // number
            if (isNumber(token)) {
                stack.push(new Constant(Double.parseDouble(token)));
            }

            // variable
            else if (token.equals("x")) {
                stack.push(new Variable());
            }

            // operator
            else if (isOperator(token)) {
                Expr right = stack.pop();
                Expr left = stack.pop();

                stack.push(new Binary(token, left, right));
            }

            else {
                throw new RuntimeException("Unknown token: " + token);
            }
        }

        return stack.pop();
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/") ||
                s.equals("^");
    }
}