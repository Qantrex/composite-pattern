package ac.at.kbauer.expressions;

/**
 * Largest of its operands. Mirrors {@link Minimum}, but reads the last (greatest)
 * element of the value-ordered operand set.
 *
 * @author kbauer
 */
public class Maximum extends VariadicOperation {

  public double calculate() {
    return super.getExpressions().last().calculate();
  }

  public String asText() {
    return super.getExpressions().last().asText();
  }

}
