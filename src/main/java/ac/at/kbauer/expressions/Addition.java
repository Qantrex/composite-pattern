package ac.at.kbauer.expressions;

/**
 * Sum of two sub-expressions.
 *
 * @author kbauer
 */
public class Addition extends BinaryOperation {

  public Addition(Expression leftOperand, Expression rightOperand) {
    super(leftOperand, rightOperand);
  }

  public double calculate() {
    return super.getLeftOperand().calculate() + super.getRightOperand().calculate();
  }

  public String asText() {
    return "(" + super.getLeftOperand().asText() + " + " + super.getRightOperand().asText() + ")";
  }
}
