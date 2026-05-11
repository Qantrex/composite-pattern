package ac.at.kbauer.expressions;

/**
 * Left operand raised to the power of the right operand.
 *
 * @author kbauer
 */
public class Exponent extends BinaryOperation {

  public Exponent(Expression leftOperand, Expression rightOperand) {
    super(leftOperand, rightOperand);
  }

  public double calculate() {
    return Math.pow(super.getLeftOperand().calculate(), super.getRightOperand().calculate());
  }

  public String asText() {
    return "(" + super.getLeftOperand().asText() + ")^(" + super.getRightOperand().asText() + ")";
  }

}
