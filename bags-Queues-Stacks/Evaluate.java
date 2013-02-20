/*
 * Evaluate.java is a stack client that evaluates fully parenthesized arithmetic
 * expressions. It uses Dijkstra's 2-stack algorithm:
 *    •Push operands onto the operand stack.
 *    •Push operator onto the operator stack.
 *    •Ignore left parenteses.
 *    •On encountering a right parethesis, pop an operator, pop the requisite
 *    number of operands, and push onto the operand stack the result of applying
 *    that operator to those operans.
 *
 * This code is a simple example of an interpreter.
 *
 * // More over, in such expressions, all parenthese are redundant!
 *    Removin them yields an expression known as a postfix expression.
 */

public class Evaluate {

    public static void main (String [] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("))
                ;
            else if (s.equals("+") || s.equals("-") ||
                     s.equals("*") || s.equals("/"))
                ops.push(s);
            else if (s.equals(")")) {
                Double v = vals.pop();
                String op = ops.pop();
                if (op.equals(("+")))       v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }

        StdOut.println(vals.pop());
    }
}
