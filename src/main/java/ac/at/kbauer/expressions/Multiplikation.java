package ac.at.kbauer.expressions;

/**
 * Product of two sub-expressions.
 *
 * @author kbauer
 */
public class Multiplikation extends BinaryOperation {

  public Multiplikation(Expression leftOperand, Expression rightOperand) {
    super(leftOperand, rightOperand);
  }

  public double calculate() {
    return super.getLeftOperand().calculate() * super.getRightOperand().calculate();
  }

  public String asText() {
    return super.getLeftOperand().asText() + " * " + super.getRightOperand().asText();
  }

}
