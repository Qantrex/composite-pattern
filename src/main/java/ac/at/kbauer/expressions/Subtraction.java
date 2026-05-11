package ac.at.kbauer.expressions;

/**
 * Left operand minus right operand.
 *
 * @author kbauer
 */
public class Subtraction extends BinaryOperation {

  public Subtraction(Expression leftOperand, Expression rightOperand) {
    super(leftOperand, rightOperand);
  }

  public double calculate() {
    return super.getLeftOperand().calculate() - super.getRightOperand().calculate();
  }

  public String asText() {
    return "(" + super.getLeftOperand().asText() + " - " + super.getRightOperand().asText() + ")";
  }

}
