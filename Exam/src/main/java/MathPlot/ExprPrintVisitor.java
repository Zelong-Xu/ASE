package MathPlot;

public interface ExprPrintVisitor {
    String visit(Constant c);
    String visit(Variable v);
    String visit(Binary b);

}