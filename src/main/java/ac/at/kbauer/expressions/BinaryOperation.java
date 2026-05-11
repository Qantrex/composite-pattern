package ac.at.kbauer.expressions;

/**
 * Composite of the Composite pattern for operations with exactly two operands.
 * Operands are themselves {@link Expression}s, allowing arbitrary nesting.
 *
 * @author kbauer
 */
public abstract class BinaryOperation implements Expression {

  // Index 0 holds the left operand, index 1 the right.
  private Expression[] expressions;

  public BinaryOperation(Expression leftOperand, Expression rightOperand) {
    this.expressions = new Expression[2];
    setLeftOperand(leftOperand);
    setRightOperand(rightOperand);
  }

  public void setLeftOperand(Expression leftOperand) {
    expressions[0] = leftOperand;
  }

  public void setRightOperand(Expression rightOperand) {
    expressions[1] = rightOperand;
  }

  public Expression getLeftOperand() {
    return expressions[0];
  }

  public Expression getRightOperand() {
    return expressions[1];
  }

  public Expression[] getExpressions() {
    return expressions;
  }

  public abstract double calculate();

  public abstract String asText();
}
