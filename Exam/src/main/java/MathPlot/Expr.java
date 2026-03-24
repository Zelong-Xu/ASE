package MathPlot;

public interface Expr {
    double accept(ExprVisitor visitor);
}
