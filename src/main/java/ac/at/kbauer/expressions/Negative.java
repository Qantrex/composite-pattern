package ac.at.kbauer.expressions;

/**
 * Unary minus: flips the sign of its operand.
 *
 * @author kbauer
 */
public class Negative extends UnaryOperation {

  public Negative(Expression expression) {
    super(expression);
  }

  public double calculate() {
    return (-1) * super.getExpression().calculate();
  }

  public String asText() {
    return "-" + super.getExpression().asText();
  }
}
