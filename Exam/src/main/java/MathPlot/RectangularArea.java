package MathPlot;

public class RectangularArea implements AreaStrategy {

    public double compute(Expr expr, double start, double end, double step) {
        double sum = 0;

        for (double x = start; x < end; x += step) {
            EvalVisitor ev = new EvalVisitor(x);
            sum += expr.accept(ev) * step;
        }

        return sum;
    }
}
