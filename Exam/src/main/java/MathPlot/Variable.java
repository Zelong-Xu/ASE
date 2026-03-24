package MathPlot;

public class Variable implements Expr {

    @Override
    public double accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }
}