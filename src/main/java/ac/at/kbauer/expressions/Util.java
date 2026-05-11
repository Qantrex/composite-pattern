package ac.at.kbauer.expressions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Helpers for building {@link Expression} trees from textual input.
 *
 * @author kbauer
 */
public class Util {

  /**
   * Parses a postfix (Reverse Polish Notation) string into an {@link Expression} tree.
   * Tokens are whitespace-separated; anything that is not a recognised operator is
   * treated as a numeric literal. The root of the resulting tree is whatever remains
   * on the stack after the last token.
   */
  public static Expression postfix(String expression) {
    Deque<Expression> stack = new ArrayDeque<>();

    for (String token : expression.trim().split("\\s+")) {
      switch (token) {
        case "+" -> {
          // Pop the right operand first so left/right order matches the input.
          Expression r = stack.pop();
          stack.push(new Addition(stack.pop(), r));
        }
        case "-" -> {
          Expression r = stack.pop();
          stack.push(new Subtraction(stack.pop(), r));
        }
        case "*" -> {
          Expression r = stack.pop();
          stack.push(new Multiplikation(stack.pop(), r));
        }
        case "/" -> {
          Expression r = stack.pop();
          stack.push(new Division(stack.pop(), r));
        }
        case "^" -> {
          Expression r = stack.pop();
          stack.push(new Exponent(stack.pop(), r));
        }
        // '~' is unary minus; '-' is reserved for binary subtraction.
        case "~" -> stack.push(new Negative(stack.pop()));
        case "sin" -> stack.push(new Sine(stack.pop()));
        case "cos" -> stack.push(new Cosine(stack.pop()));
        case "ln" -> stack.push(new Logarithm(stack.pop()));
        case "min" -> {
          Expression r = stack.pop();
          Minimum m = new Minimum();
          m.addExpression(stack.pop());
          m.addExpression(r);
          stack.push(m);
        }
        case "max" -> {
          Expression r = stack.pop();
          Maximum m = new Maximum();
          m.addExpression(stack.pop());
          m.addExpression(r);
          stack.push(m);
        }
        default -> stack.push(new Number(Double.parseDouble(token)));
      }
    }

    return stack.pop();
  }
}
