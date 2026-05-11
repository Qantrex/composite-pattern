package ac.at.kbauer.expressions;

/**
 * Composite of the Composite pattern for operations with a single operand
 * (e.g. negation, sin, cos, ln).
 *
 * @author kbauer
 */
public abstract class UnaryOperation implements Expression {
  private Expression expression;

  public UnaryOperation(Expression expression) {
    this.expression = expression;
  }

  public Expression getExpression() {
    return expression;
  }

  public void setExpression(Expression expression) {
    this.expression = expression;
  }

  public abstract double calculate();

  public abstract String asText();

}
