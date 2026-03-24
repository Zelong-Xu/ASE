package MathPlot;

public class Constant implements Expr {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public double accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }
}