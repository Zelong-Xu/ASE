package MathPlot;

import MathPlot.Parsers.AOS;

public class AOSBuilder implements ExpressionBuilder {

    @Override
    public Expr build(String input) {
        if (input == null) throw new IllegalArgumentException("AOS input is null");

        AOS parser = new AOS();
        try {
            AOS.Parts p = parser.parse(input);

            // leaf node
            if (p.left == null && p.right == null) {
                if (p.main.equalsIgnoreCase("x")) return new Variable();
                return new Constant(Double.parseDouble(p.main));
            }

            // unary function node: main=function, left=arg, right=null
            if (p.left != null && p.right == null && isFunctionName(p.main)) {
                String fn = normalizeFunctionName(p.main);
                return new UnaryFunction(fn, build(p.left));
            }

            // binary node
            if (p.left != null && p.right != null) {
                return new Binary(p.main, build(p.left), build(p.right));
            }

            throw new IllegalArgumentException("Unsupported AOS parts: main=" + p.main);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isFunctionName(String name) {
        String n = name.toLowerCase();
        return n.equals("sin") || n.equals("cos") || n.equals("exp") || n.equals("log") || n.equals("ln");
    }

    private String normalizeFunctionName(String name) {
        String n = name.toLowerCase();
        if (n.equals("ln")) return "log";
        return n;
    }
}
