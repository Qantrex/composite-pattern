package ac.at.kbauer.expressions;

/**
 * Leaf of the Composite pattern: wraps a constant numeric value.
 *
 * @author kbauer
 */
public final class Number implements Expression {
  private double num;

  public Number(double num) {
    this.num = num;
  }

  public double calculate() {
    return getNum();
  }

  public String asText() {
    return String.valueOf(getNum());
  }

  public double getNum() {
    return num;
  }

  public void setNum(double num) {
    this.num = num;
  }

  /** Equality is based on the numeric value, consistent with {@link Expression#compareTo}. */
  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof Number))
      return false;
    return ((Number) obj).compareTo(this) == 0;
  }

  @Override
  public int hashCode() {
    return Double.hashCode(num);
  }
}
