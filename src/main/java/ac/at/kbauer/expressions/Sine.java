package ac.at.kbauer.expressions;

/**
 * Sine of its operand. The operand is interpreted as radians.
 *
 * @author kbauer
 */
public class Sine extends UnaryOperation {

  public Sine(Expression expression) {
    super(expression);
  }

  @Override
  public String asText() {
    return "sin(" + super.getExpression().asText() + ")";
  }

  @Override
  public double calculate() {
    return Math.sin(super.getExpression().calculate());
  }

}
