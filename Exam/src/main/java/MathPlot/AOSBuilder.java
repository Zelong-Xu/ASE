package MathPlot;

import MathPlot.Parsers.AOS;

public class AOSBuilder implements ExpressionBuilder {

    @Override
    public Expr build(String input) {
        AOS parser = new AOS();

        try {
            AOS.Parts p = parser.parse(input);

            // leaf node
            if (p.left == null && p.right == null) {
                if (p.main.equals("x")) return new Variable();
                return new Constant(Double.parseDouble(p.main));
            }

            // binary node
            return new Binary(
                    p.main,
                    build(p.left),
                    build(p.right)
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
