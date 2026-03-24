
package MathPlot;

public class UnaryFunction implements Expr {

    private final String name;
    private final Expr arg;

    public UnaryFunction(String name, Expr arg) {
        this.name = name.toLowerCase();
        this.arg = arg;
    }

    public String getName() {
        return name;
    }

    public Expr getArg() {
        return arg;
    }

    @Override
    public double accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }
}
