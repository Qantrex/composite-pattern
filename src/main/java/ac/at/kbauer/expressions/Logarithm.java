package ac.at.kbauer.expressions;

/**
 * Natural logarithm (base e) of its operand. Non-positive operands yield NaN.
 *
 * @author kbauer
 */
public class Logarithm extends UnaryOperation {

  public Logarithm(Expression expression) {
    super(expression);
  }

  @Override
  public String asText() {
    return "ln(" + super.getExpression().asText() + ")";
  }

  @Override
  public double calculate() {
    return Math.log(super.getExpression().calculate());
  }

}
