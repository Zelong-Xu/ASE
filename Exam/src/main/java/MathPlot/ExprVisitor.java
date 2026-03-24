package MathPlot;

public interface ExprVisitor {
    double visit(Constant c);
    double visit(Variable v);
    double visit(Binary b);
}