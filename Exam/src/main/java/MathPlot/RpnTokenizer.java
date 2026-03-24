package MathPlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RpnTokenizer {

    private static final Set<String> FUNCTIONS = Set.of("sin", "cos", "exp", "log");
    private static final Set<Character> OPERATORS = Set.of('+', '-', '*', '/', '^');

    private RpnTokenizer() {}

    public static List<String> tokenize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("RPN input is null");
        }

        final String s = input.trim();
        if (s.isEmpty()) {
            return List.of();
        }

        boolean hasWhitespace = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isWhitespace(s.charAt(i))) {
                hasWhitespace = true;
                break;
            }
        }

        if (hasWhitespace) {
            final String[] raw = s.split("\\s+");
            final List<String> out = new ArrayList<>();
            for (String t : raw) {
                if (!t.isEmpty()) out.add(t.toLowerCase());
            }
            return out;
        }

        final List<String> out = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (OPERATORS.contains(c)) {
                out.add(String.valueOf(c));
                i++;
                continue;
            }

            if (Character.isDigit(c) || c == '.') {
                int start = i;
                i++;

                while (i < s.length()) {
                    char ch = s.charAt(i);
                    if (Character.isDigit(ch) || ch == '.') {
                        i++;
                        continue;
                    }

                    if (ch == 'e' || ch == 'E') {
                        int ePos = i;
                        i++;
                        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
                        int digitsStart = i;
                        while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
                        if (digitsStart == i) {

                            i = ePos;
                        }
                        continue;
                    }
                    break;
                }

                out.add(s.substring(start, i));
                continue;
            }


            if (Character.isLetter(c)) {

                boolean matchedFunction = false;
                for (String fn : FUNCTIONS) {
                    int end = i + fn.length();
                    if (end <= s.length() && s.substring(i, end).equalsIgnoreCase(fn)) {
                        out.add(fn);
                        i = end;
                        matchedFunction = true;
                        break;
                    }
                }
                if (matchedFunction) continue;


                if (c == 'x' || c == 'X') {
                    out.add("x");
                    i++;
                    continue;
                }

                throw new IllegalArgumentException("Unknown identifier in RPN: " + c + " at pos " + i);
            }

            throw new IllegalArgumentException("Illegal char in RPN: " + c + " at pos " + i);
        }

        return out;
    }
}
