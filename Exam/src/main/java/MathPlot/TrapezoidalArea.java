package MathPlot;

public class TrapezoidalArea implements AreaStrategy {

    public double compute(Expr expr, double start, double end, double step) {
        double sum = 0;

        for (double x = start; x < end; x += step) {
            EvalVisitor ev1 = new EvalVisitor(x);
            EvalVisitor ev2 = new EvalVisitor(x + step);

            sum += (expr.accept(ev1) + expr.accept(ev2)) * step / 2;
        }

        return sum;
    }
}