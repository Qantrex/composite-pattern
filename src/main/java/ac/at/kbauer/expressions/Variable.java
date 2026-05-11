package ac.at.kbauer.expressions;

/**
 * Leaf of the Composite pattern: a named placeholder whose value is resolved
 * from {@link Context} at evaluation time.
 *
 * @author kbauer
 */
public class Variable implements Expression {
  private String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public String asText() {
    return name;
  }

  @Override
  public double calculate() {
    return Context.get(name);
  }
}
