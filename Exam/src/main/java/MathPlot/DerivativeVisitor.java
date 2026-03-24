package MathPlot;

public class DerivativeVisitor {

    public Expr derive(Expr expr) {
        if (expr instanceof Constant) return new Constant(0);
        if (expr instanceof Variable) return new Constant(1);

        if (expr instanceof UnaryFunction u) {
            Expr uArg = u.getArg();
            Expr du = derive(uArg);

            return switch (u.getName()) {
                case "sin" -> new Binary("*", new UnaryFunction("cos", uArg), du);
                case "cos" -> new Binary("*",
                        new Binary("*", new Constant(-1), new UnaryFunction("sin", uArg)),
                        du);
                case "exp" -> new Binary("*", new UnaryFunction("exp", uArg), du);
                case "log" -> new Binary("/", du, uArg);
                default -> throw new RuntimeException("Unsupported function derivative: " + u.getName());
            };
        }

        if (expr instanceof Binary b) {
            String op = b.getOp();
            Expr left = b.getLeft();
            Expr right = b.getRight();

            if (op.equals("+")) return new Binary("+", derive(left), derive(right));
            if (op.equals("-")) return new Binary("-", derive(left), derive(right));
            if (op.equals("*")) {
                return new Binary("+",
                        new Binary("*", derive(left), right),
                        new Binary("*", left, derive(right)));
            }
            if (op.equals("/")) {
                return new Binary("/",
                        new Binary("-",
                                new Binary("*", derive(left), right),
                                new Binary("*", left, derive(right))),
                        new Binary("^", right, new Constant(2)));
            }
            if (op.equals("^")) {
                if (right instanceof Constant c) {
                    double n = c.getValue();
                    return new Binary("*",
                            new Constant(n),
                            new Binary("^", left, new Constant(n - 1)));
                }
                throw new RuntimeException("Unsupported power derivative");
            }
        }

        throw new RuntimeException("Unknown expression type");
    }
}
