package ac.at.kbauer.expressions;

/**
 * Component of the Composite pattern: the common interface implemented by both
 * leaves ({@link Number}, {@link Variable}) and composites (operations).
 *
 * @author kbauer
 */
public interface Expression extends Comparable<Expression> {

  /** Evaluates the expression tree and returns the numeric result. */
  public abstract double calculate();

  /** Renders the expression tree as a human-readable string. */
  public abstract String asText();

  /** Natural ordering is by computed value, which lets {@link VariadicOperation} use sorted sets. */
  @Override
  default int compareTo(Expression expression) {
    return Double.compare(this.calculate(), expression.calculate());
  }
}
