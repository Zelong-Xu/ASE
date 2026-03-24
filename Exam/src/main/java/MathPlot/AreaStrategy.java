package MathPlot;

public interface AreaStrategy {
    double compute(Expr expr, double start, double end, double step);
}
