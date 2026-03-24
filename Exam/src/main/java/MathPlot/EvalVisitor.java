package MathPlot;

public class EvalVisitor implements ExprVisitor {
    private final double xValue;

    public EvalVisitor(double xValue) {
        this.xValue = xValue;
    }

    @Override
    public double visit(Constant c) {
        return c.getValue();
    }

    @Override
    public double visit(Variable v) {
        return xValue;
    }

    @Override
    public double visit(Binary b) {
        double leftValue = b.getLeft().accept(this);
        double rightValue = b.getRight().accept(this);

        return switch (b.getOp()) {
            case "+" -> leftValue + rightValue;
            case "-" -> leftValue - rightValue;
            case "*" -> leftValue * rightValue;
            case "/" -> leftValue / rightValue;
            case "^" -> Math.pow(leftValue, rightValue);
            default -> throw new IllegalArgumentException("Unknown operator: " + b.getOp());
        };
    }
}