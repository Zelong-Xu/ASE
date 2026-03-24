package MathPlot;

public class RPNPrintVisitor {

    public String print(Expr expr) {
        if (expr instanceof Constant c) {
            return formatNumber(c.getValue());
        }

        if (expr instanceof Variable) {
            return "x";
        }

        if (expr instanceof Binary b) {
            String left = print(b.getLeft());
            String right = print(b.getRight());
            return left + " " + right + " " + b.getOp();
        }

        throw new IllegalArgumentException("Unknown expression type");
    }

    private String formatNumber(double value) {
        if (value == (long) value) {
            return Long.toString((long) value);
        }
        return Double.toString(value);
    }
}