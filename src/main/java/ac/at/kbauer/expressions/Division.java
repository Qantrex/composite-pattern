package ac.at.kbauer.expressions;

/**
 * Left operand divided by right operand. Division by zero yields IEEE 754
 * infinity rather than throwing.
 *
 * @author kbauer
 */
public class Division extends BinaryOperation {

  public Division(Expression leftOperand, Expression rightOperand) {
    super(leftOperand, rightOperand);
  }

  public double calculate() {
    return super.getLeftOperand().calculate() / super.getRightOperand().calculate();
  }

  public String asText() {
    return "(" + super.getLeftOperand().asText() + " / " + super.getRightOperand().asText() + ")";
  }

}
