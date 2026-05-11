package ac.at.kbauer.expressions;

/**
 * Cosine of its operand. The operand is interpreted as radians.
 *
 * @author kbauer
 */
public class Cosine extends UnaryOperation {

  public Cosine(Expression expression) {
    super(expression);
  }

  @Override
  public String asText() {
    return "cos(" + super.getExpression().asText() + ")";
  }

  @Override
  public double calculate() {
    return Math.cos(super.getExpression().calculate());
  }

}
