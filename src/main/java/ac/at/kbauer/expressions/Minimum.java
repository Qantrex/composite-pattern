package ac.at.kbauer.expressions;

/**
 * Smallest of its operands. Relies on the operand set being ordered by value
 * via {@link Expression#compareTo}, so the minimum is simply the first element.
 *
 * @author kbauer
 */
public class Minimum extends VariadicOperation {

  public double calculate() {
    return super.getExpressions().first().calculate();
  }

  public String asText() {
    return super.getExpressions().first().asText();
  }

}
