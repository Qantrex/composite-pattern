package ac.at.kbauer.expressions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link Expression} hierarchy and the postfix parser.
 *
 * @author kbauer
 */
@DisplayName("Expression Library Tests")
public class ExpressionTest {

  // ─────────────────────────────────────────────
  // Number
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Number")
  class NumberTests {

    @Test
    @DisplayName("calculate() returns the stored value")
    void calculateReturnsValue() {
      Number n = new Number(42.0);
      assertEquals(42.0, n.calculate());
    }

    @Test
    @DisplayName("asText() returns the string representation")
    void asTextReturnsString() {
      Number n = new Number(3.14);
      assertEquals("3.14", n.asText());
    }

    @Test
    @DisplayName("equals() returns true for same numeric value")
    void equalsForSameValue() {
      assertEquals(new Number(5.0), new Number(5.0));
    }

    @Test
    @DisplayName("equals() returns false for different values")
    void notEqualsForDifferentValues() {
      assertNotEquals(new Number(1.0), new Number(2.0));
    }

    @Test
    @DisplayName("equals() returns false for null")
    void notEqualsNull() {
      assertNotEquals(new Number(1.0), null);
    }

    @Test
    @DisplayName("hashCode() is consistent with equals()")
    void hashCodeConsistency() {
      Number a = new Number(7.0);
      Number b = new Number(7.0);
      assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    @DisplayName("setNum() updates the value")
    void setNumUpdatesValue() {
      Number n = new Number(1.0);
      n.setNum(99.0);
      assertEquals(99.0, n.calculate());
    }

    @Test
    @DisplayName("compareTo() orders numbers correctly")
    void compareToOrdersCorrectly() {
      Number small = new Number(1.0);
      Number large = new Number(10.0);
      assertTrue(small.compareTo(large) < 0);
      assertTrue(large.compareTo(small) > 0);
      assertEquals(0, small.compareTo(new Number(1.0)));
    }
  }

  // ─────────────────────────────────────────────
  // Addition
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Addition")
  class AdditionTests {

    @Test
    @DisplayName("calculate() sums two numbers")
    void calculateSums() {
      Addition add = new Addition(new Number(3.0), new Number(4.0));
      assertEquals(7.0, add.calculate());
    }

    @Test
    @DisplayName("asText() formats with parentheses and plus sign")
    void asTextFormat() {
      Addition add = new Addition(new Number(3.0), new Number(4.0));
      assertEquals("(3.0 + 4.0)", add.asText());
    }

    @Test
    @DisplayName("calculate() handles negative operands")
    void calculateWithNegatives() {
      Addition add = new Addition(new Number(-5.0), new Number(3.0));
      assertEquals(-2.0, add.calculate());
    }

    @Test
    @DisplayName("nested addition")
    void nestedAddition() {
      // (1 + 2) + 3 = 6
      Addition inner = new Addition(new Number(1.0), new Number(2.0));
      Addition outer = new Addition(inner, new Number(3.0));
      assertEquals(6.0, outer.calculate());
    }
  }

  // ─────────────────────────────────────────────
  // Subtraction
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Subtraction")
  class SubtractionTests {

    @Test
    @DisplayName("calculate() subtracts right from left")
    void calculateSubtracts() {
      Subtraction sub = new Subtraction(new Number(10.0), new Number(3.0));
      assertEquals(7.0, sub.calculate());
    }

    @Test
    @DisplayName("asText() formats correctly")
    void asTextFormat() {
      Subtraction sub = new Subtraction(new Number(10.0), new Number(3.0));
      assertEquals("(10.0 - 3.0)", sub.asText());
    }

    @Test
    @DisplayName("calculate() produces negative result when right > left")
    void calculateNegativeResult() {
      Subtraction sub = new Subtraction(new Number(2.0), new Number(5.0));
      assertEquals(-3.0, sub.calculate());
    }
  }

  // ─────────────────────────────────────────────
  // Multiplikation
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Multiplikation")
  class MultiplikationTests {

    @Test
    @DisplayName("calculate() multiplies two numbers")
    void calculateMultiplies() {
      Multiplikation mul = new Multiplikation(new Number(6.0), new Number(7.0));
      assertEquals(42.0, mul.calculate());
    }

    @Test
    @DisplayName("asText() formats without extra parentheses")
    void asTextFormat() {
      Multiplikation mul = new Multiplikation(new Number(6.0), new Number(7.0));
      assertEquals("6.0 * 7.0", mul.asText());
    }

    @Test
    @DisplayName("calculate() with zero yields zero")
    void calculateWithZero() {
      Multiplikation mul = new Multiplikation(new Number(999.0), new Number(0.0));
      assertEquals(0.0, mul.calculate());
    }

    @Test
    @DisplayName("calculate() with negative operand")
    void calculateWithNegative() {
      Multiplikation mul = new Multiplikation(new Number(-3.0), new Number(4.0));
      assertEquals(-12.0, mul.calculate());
    }
  }

  // ─────────────────────────────────────────────
  // Division
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Division")
  class DivisionTests {

    @Test
    @DisplayName("calculate() divides correctly")
    void calculateDivides() {
      Division div = new Division(new Number(10.0), new Number(4.0));
      assertEquals(2.5, div.calculate());
    }

    @Test
    @DisplayName("asText() formats with parentheses and slash")
    void asTextFormat() {
      Division div = new Division(new Number(10.0), new Number(4.0));
      assertEquals("(10.0 / 4.0)", div.asText());
    }

    @Test
    @DisplayName("calculate() dividing by zero yields Infinity")
    void divideByZeroYieldsInfinity() {
      Division div = new Division(new Number(1.0), new Number(0.0));
      assertTrue(Double.isInfinite(div.calculate()));
    }
  }

  // ─────────────────────────────────────────────
  // Exponent
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Exponent")
  class ExponentTests {

    @Test
    @DisplayName("calculate() raises base to power")
    void calculatePow() {
      Exponent exp = new Exponent(new Number(2.0), new Number(10.0));
      assertEquals(1024.0, exp.calculate());
    }

    @Test
    @DisplayName("asText() formats with caret notation")
    void asTextFormat() {
      Exponent exp = new Exponent(new Number(2.0), new Number(10.0));
      assertEquals("(2.0)^(10.0)", exp.asText());
    }

    @Test
    @DisplayName("calculate() with exponent 0 yields 1")
    void exponentZero() {
      Exponent exp = new Exponent(new Number(99.0), new Number(0.0));
      assertEquals(1.0, exp.calculate());
    }

    @Test
    @DisplayName("calculate() with exponent 1 returns base")
    void exponentOne() {
      Exponent exp = new Exponent(new Number(7.5), new Number(1.0));
      assertEquals(7.5, exp.calculate());
    }

    @Test
    @DisplayName("calculate() with fractional exponent computes root")
    void fractionalExponent() {
      Exponent exp = new Exponent(new Number(9.0), new Number(0.5));
      assertEquals(3.0, exp.calculate(), 1e-10);
    }
  }

  // ─────────────────────────────────────────────
  // Negative
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Negative")
  class NegativeTests {

    @Test
    @DisplayName("calculate() negates positive number")
    void negatesPositive() {
      Negative neg = new Negative(new Number(5.0));
      assertEquals(-5.0, neg.calculate());
    }

    @Test
    @DisplayName("calculate() negating a negative yields positive")
    void negatesNegative() {
      Negative neg = new Negative(new Number(-3.0));
      assertEquals(3.0, neg.calculate());
    }

    @Test
    @DisplayName("asText() prepends minus sign")
    void asTextFormat() {
      Negative neg = new Negative(new Number(5.0));
      assertEquals("-5.0", neg.asText());
    }

    @Test
    @DisplayName("double negation returns original value")
    void doubleNegation() {
      Negative neg = new Negative(new Negative(new Number(8.0)));
      assertEquals(8.0, neg.calculate());
    }
  }

  // ─────────────────────────────────────────────
  // Sine
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Sine")
  class SineTests {

    @Test
    @DisplayName("calculate() of 0 is 0")
    void sinZero() {
      assertEquals(0.0, new Sine(new Number(0.0)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of PI/2 is 1")
    void sinHalfPi() {
      assertEquals(1.0, new Sine(new Number(Math.PI / 2)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of PI is ~0")
    void sinPi() {
      assertEquals(0.0, new Sine(new Number(Math.PI)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("asText() wraps argument in sin()")
    void asTextFormat() {
      Sine sine = new Sine(new Number(0.0));
      assertEquals("sin(0.0)", sine.asText());
    }
  }

  // ─────────────────────────────────────────────
  // Cosine
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Cosine")
  class CosineTests {

    @Test
    @DisplayName("calculate() of 0 is 1")
    void cosZero() {
      assertEquals(1.0, new Cosine(new Number(0.0)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of PI is -1")
    void cosPi() {
      assertEquals(-1.0, new Cosine(new Number(Math.PI)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of PI/2 is ~0")
    void cosHalfPi() {
      assertEquals(0.0, new Cosine(new Number(Math.PI / 2)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("asText() wraps argument in cos()")
    void asTextFormat() {
      Cosine cosine = new Cosine(new Number(0.0));
      assertEquals("cos(0.0)", cosine.asText());
    }
  }

  // ─────────────────────────────────────────────
  // Logarithm
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Logarithm (natural log)")
  class LogarithmTests {

    @Test
    @DisplayName("calculate() of 1 is 0")
    void lnOne() {
      assertEquals(0.0, new Logarithm(new Number(1.0)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of e is 1")
    void lnE() {
      assertEquals(1.0, new Logarithm(new Number(Math.E)).calculate(), 1e-10);
    }

    @Test
    @DisplayName("calculate() of a negative number is NaN")
    void lnNegativeIsNaN() {
      assertTrue(Double.isNaN(new Logarithm(new Number(-1.0)).calculate()));
    }

    @Test
    @DisplayName("asText() wraps argument in ln()")
    void asTextFormat() {
      Logarithm log = new Logarithm(new Number(1.0));
      assertEquals("ln(1.0)", log.asText());
    }
  }

  // ─────────────────────────────────────────────
  // VariadicOperation / Minimum / Maximum
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Minimum")
  class MinimumTests {

    @Test
    @DisplayName("calculate() returns the smallest value")
    void returnsSmallest() {
      Minimum min = new Minimum();
      min.addExpression(new Number(5.0));
      min.addExpression(new Number(1.0));
      min.addExpression(new Number(3.0));
      assertEquals(1.0, min.calculate());
    }

    @Test
    @DisplayName("asText() returns text of the smallest expression")
    void asTextOfSmallest() {
      Minimum min = new Minimum();
      min.addExpression(new Number(5.0));
      min.addExpression(new Number(1.0));
      assertEquals("1.0", min.asText());
    }

    @Test
    @DisplayName("single element returns that element")
    void singleElement() {
      Minimum min = new Minimum();
      min.addExpression(new Number(42.0));
      assertEquals(42.0, min.calculate());
    }
  }

  @Nested
  @DisplayName("Maximum")
  class MaximumTests {

    @Test
    @DisplayName("calculate() returns the largest value")
    void returnsLargest() {
      Maximum max = new Maximum();
      max.addExpression(new Number(5.0));
      max.addExpression(new Number(1.0));
      max.addExpression(new Number(3.0));
      assertEquals(5.0, max.calculate());
    }

    @Test
    @DisplayName("asText() returns text of the largest expression")
    void asTextOfLargest() {
      Maximum max = new Maximum();
      max.addExpression(new Number(2.0));
      max.addExpression(new Number(9.0));
      assertEquals("9.0", max.asText());
    }

    @Test
    @DisplayName("removeExpression() removes an element")
    void removeExpression() {
      Maximum max = new Maximum();
      Number n5 = new Number(5.0);
      Number n9 = new Number(9.0);
      max.addExpression(n5);
      max.addExpression(n9);
      assertTrue(max.removeExpression(n9));
      assertEquals(5.0, max.calculate());
    }

    @Test
    @DisplayName("removeExpression() returns false for absent element")
    void removeAbsentExpression() {
      Maximum max = new Maximum();
      max.addExpression(new Number(1.0));
      assertFalse(max.removeExpression(new Number(99.0)));
    }
  }

  // ─────────────────────────────────────────────
  // BinaryOperation setters
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("BinaryOperation operand setters")
  class BinaryOperationSetterTests {

    @Test
    @DisplayName("setLeftOperand() changes left operand")
    void setLeftOperand() {
      Addition add = new Addition(new Number(1.0), new Number(2.0));
      add.setLeftOperand(new Number(10.0));
      assertEquals(12.0, add.calculate());
    }

    @Test
    @DisplayName("setRightOperand() changes right operand")
    void setRightOperand() {
      Addition add = new Addition(new Number(1.0), new Number(2.0));
      add.setRightOperand(new Number(20.0));
      assertEquals(21.0, add.calculate());
    }
  }

  // ─────────────────────────────────────────────
  // Composite / Integration tests
  // ─────────────────────────────────────────────

  @Nested
  @DisplayName("Composite expressions")
  class CompositeTests {

    @Test
    @DisplayName("sin²(x) + cos²(x) == 1  (Pythagorean identity)")
    void pythagoreanIdentity() {
      Number x = new Number(1.23);
      Sine sin = new Sine(x);
      Cosine cos = new Cosine(x);
      Addition sum = new Addition(
          new Exponent(sin, new Number(2.0)),
          new Exponent(cos, new Number(2.0)));
      assertEquals(1.0, sum.calculate(), 1e-10);
    }

    @Test
    @DisplayName("ln(e^x) == x  (log-exp inverse)")
    void logExpInverse() {
      double xVal = 3.5;
      Logarithm result = new Logarithm(new Exponent(new Number(Math.E), new Number(xVal)));
      assertEquals(xVal, result.calculate(), 1e-10);
    }

    @Test
    @DisplayName("-(a - b) == b - a")
    void negationOfSubtraction() {
      Number a = new Number(7.0);
      Number b = new Number(3.0);
      Negative negSub = new Negative(new Subtraction(a, b));
      Subtraction bMinusA = new Subtraction(b, a);
      assertEquals(bMinusA.calculate(), negSub.calculate(), 1e-10);
    }

    @Test
    @DisplayName("asText() of a nested expression is readable")
    void nestedAsText() {
      // sin((3.0 + 4.0))
      Sine sine = new Sine(new Addition(new Number(3.0), new Number(4.0)));
      assertEquals("sin((3.0 + 4.0))", sine.asText());
    }

    @Test
    @DisplayName("Expression compareTo() used correctly in TreeSet ordering")
    void treeSetOrdering() {
      Maximum max = new Maximum();
      max.addExpression(new Addition(new Number(2.0), new Number(3.0))); // 5
      max.addExpression(new Number(10.0)); // 10
      max.addExpression(new Negative(new Number(1.0))); // -1
      assertEquals(10.0, max.calculate());

      Minimum min = new Minimum();
      min.addExpression(new Addition(new Number(2.0), new Number(3.0))); // 5
      min.addExpression(new Number(10.0)); // 10
      min.addExpression(new Negative(new Number(1.0))); // -1
      assertEquals(-1.0, min.calculate());
    }
  }

  @Nested
  @DisplayName("Util.postfix()")
  class PostfixTests {

    @Test
    @DisplayName("2 + 3 = 5")
    void addition() {
      assertEquals(5.0, Util.postfix("2 3 +").calculate());
    }

    @Test
    @DisplayName("2 + 3 * 4 = 14")
    void precedence() {
      assertEquals(14.0, Util.postfix("2 3 4 * +").calculate());
    }

    @Test
    @DisplayName("(2 + 3) * 4 = 20")
    void parenthesized() {
      assertEquals(20.0, Util.postfix("2 3 + 4 *").calculate());
    }

    @Test
    @DisplayName("unary minus: 3 ~ = -3")
    void unaryMinus() {
      assertEquals(-3.0, Util.postfix("3 ~").calculate());
    }

    @Test
    @DisplayName("sin(0) = 0")
    void sine() {
      assertEquals(0.0, Util.postfix("0 sin").calculate(), 1e-10);
    }

    @Test
    @DisplayName("min(2, 3, 4) chained = 2")
    void minChained() {
      assertEquals(2.0, Util.postfix("2 3 min 4 min").calculate());
    }
  }

  @Nested
  @DisplayName("Variable")
  class VariableTests {

    @Test
    @DisplayName("calculate() returns the value set in Context")
    void returnsContextValue() {
      Context.set("x", 7.0);
      assertEquals(7.0, new Variable("x").calculate());
    }

    @Test
    @DisplayName("calculate() reflects updated Context value")
    void updatesWithContext() {
      Expression expr = new Variable("x");
      Context.set("x", 1.0);
      assertEquals(1.0, expr.calculate());
      Context.set("x", 99.0);
      assertEquals(99.0, expr.calculate());
    }

    @Test
    @DisplayName("asText() returns the variable name")
    void asTextReturnsName() {
      assertEquals("x", new Variable("x").asText());
    }

    @Test
    @DisplayName("calculate() throws when variable not set")
    void throwsIfNotSet() {
      assertThrows(IllegalArgumentException.class, () -> new Variable("undefined").calculate());
    }
  }
}
