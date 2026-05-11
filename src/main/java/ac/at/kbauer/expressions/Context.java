package ac.at.kbauer.expressions;

import java.util.HashMap;
import java.util.Map;

/**
 * Process-wide registry mapping {@link Variable} names to their current values.
 * State is shared across all evaluations and not thread-safe.
 *
 * @author kbauer
 */
public class Context {
  private static Map<String, Double> variables = new HashMap<>();

  public static void set(String name, double value) {
    variables.put(name, value);
  }

  /** @throws IllegalArgumentException if no value has been set for {@code name}. */
  public static double get(String name) {
    if (!variables.containsKey(name)) {
      throw new IllegalArgumentException("Variable '" + name + "' not set");
    }
    return variables.get(name);
  }
}
