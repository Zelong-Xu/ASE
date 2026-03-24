package MathPlot;

public class DerivativeVisitor {

    public Expr derive(Expr expr) {

        // Constant → 0
        if (expr instanceof Constant c) {
            return new Constant(0);
        }

        // Variable → 1
        if (expr instanceof Variable) {
            return new Constant(1);
        }

        // Binary expression
        if (expr instanceof Binary b) {

            String op = b.getOp();
            Expr left = b.getLeft();
            Expr right = b.getRight();

            // Addition: (f + g)' = f' + g'
            if (op.equals("+")) {
                return new Binary("+",
                        derive(left),
                        derive(right));
            }

            // Subtraction: (f - g)' = f' - g'
            if (op.equals("-")) {
                return new Binary("-",
                        derive(left),
                        derive(right));
            }

            // Multiplication: (f * g)' = f'*g + f*g'
            if (op.equals("*")) {
                return new Binary("+",
                        new Binary("*", derive(left), right),
                        new Binary("*", left, derive(right)));
            }

            // Division: (f / g)' = (f'*g - f*g') / g^2
            if (op.equals("/")) {
                return new Binary("/",
                        new Binary("-",
                                new Binary("*", derive(left), right),
                                new Binary("*", left, derive(right))),
                        new Binary("^", right, new Constant(2)));
            }

            // Power: (x^n)' = n*x^(n-1)  (只处理右边是常数)
            if (op.equals("^")) {

                // only support x^constant
                if (right instanceof Constant c) {
                    double n = c.getValue();

                    return new Binary("*",
                            new Constant(n),
                            new Binary("^",
                                    left,
                                    new Constant(n - 1)));
                }

                // 其他情况不处理（考试够用）
                throw new RuntimeException("Unsupported power derivative");
            }
        }

        throw new RuntimeException("Unknown expression type");
    }
}