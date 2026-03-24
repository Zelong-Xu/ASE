package MathPlot;

import java.util.List;
import java.util.Stack;

public class RPNBuilder implements ExpressionBuilder {

    @Override
    public Expr build(String input) {
        final List<String> tokens = RpnTokenizer.tokenize(input);
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Empty RPN expression");
        }

        final Stack<Expr> stack = new Stack<>();

        for (String token : tokens) {
            // number
            if (isNumber(token)) {
                stack.push(new Constant(Double.parseDouble(token)));
                continue;
            }

            // variable
            if ("x".equals(token)) {
                stack.push(new Variable());
                continue;
            }

            // operator (binary)
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("RPN operator '" + token + "' requires 2 operands");
                }
                Expr right = stack.pop();
                Expr left = stack.pop();
                stack.push(new Binary(token, left, right));
                continue;
            }

            // function (unary) - will require UnaryFunction node (see later section)
            if (isFunction(token)) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("RPN function '" + token + "' requires 1 operand");
                }
                Expr arg = stack.pop();
                stack.push(new UnaryFunction(token, arg));
                continue;
            }

            throw new IllegalArgumentException("Unknown RPN token: " + token);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN: remaining stack size = " + stack.size());
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
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    private boolean isFunction(String s) {
        return s.equals("sin") || s.equals("cos") || s.equals("exp") || s.equals("log");
    }
}
