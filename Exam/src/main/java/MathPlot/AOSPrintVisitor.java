package MathPlot;

public class AOSPrintVisitor {

    public String print(Expr expr) {
        if (expr instanceof Constant c) return formatNumber(c.getValue());
        if (expr instanceof Variable) return "x";

        if (expr instanceof UnaryFunction u) {
            return u.getName() + "(" + print(u.getArg()) + ")";
        }

        if (expr instanceof Binary b) {
            return "(" + print(b.getLeft()) + " " + b.getOp() + " " + print(b.getRight()) + ")";
        }

        throw new IllegalArgumentException("Unknown expression type");
    }

    private String formatNumber(double value) {
        if (value == (long) value) return Long.toString((long) value);
        return Double.toString(value);
    }
}
