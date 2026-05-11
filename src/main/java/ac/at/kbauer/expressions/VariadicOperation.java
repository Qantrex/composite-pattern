package ac.at.kbauer.expressions;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Composite of the Composite pattern for operations over a variable number of
 * operands. Operands are kept in a {@link NavigableSet} ordered by their
 * computed value, so subclasses like {@link Minimum} and {@link Maximum} can
 * pick the boundary element in O(log n).
 *
 * @author kbauer
 */
public abstract class VariadicOperation implements Expression {

  private NavigableSet<Expression> expressions;

  public VariadicOperation(NavigableSet<Expression> expressions) {
    this.expressions = expressions;
  }

  public VariadicOperation() {
    this.expressions = new TreeSet<>();
  }

  public abstract double calculate();

  public abstract String asText();

  public void addExpression(Expression expression) {
    expressions.add(expression);
  }

  public boolean removeExpression(Expression expression) {
    return expressions.remove(expression);
  }

  public NavigableSet<Expression> getExpressions() {
    return expressions;
  }

}
