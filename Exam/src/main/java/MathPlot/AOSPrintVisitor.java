package MathPlot;

public class AOSPrintVisitor {

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
            return "(" + left + " " + b.getOp() + " " + right + ")";
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