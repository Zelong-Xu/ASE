package MathPlot;

public class Binary implements Expr {
    private final String op;
    private final Expr left;
    private final Expr right;

    public Binary(String op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public String getOp() {
        return op;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }

    @Override
    public double accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }
}