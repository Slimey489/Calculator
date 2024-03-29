import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class EvaluateExpressionTest {

    @Test
    void evaluate_basic_scientific_notation() {
        assertEquals("1.0E9", new EvaluateExpression().evaluate("10^9"));
    }

    @Test
    void evaluate_basic_exponent() {
        assertEquals("8.0", new EvaluateExpression().evaluate("2^3"));
    }

    @Test
    void evaluate_basic_add() {
        assertEquals("2.0", new EvaluateExpression().evaluate("1+1"));
    }

    @Test
    void evaluate_basic_multiplication() {
        assertEquals("4.0", new EvaluateExpression().evaluate("2*2"));
    }

    @Test
    void evaluate_basic_division() {
        assertEquals("1.0", new EvaluateExpression().evaluate("2/2"));
    }

    @Test
    void evaluate_basic_subtraction() {
        assertEquals("0.0", new EvaluateExpression().evaluate("2-2"));
    }

    @Test
    void evaluate_complex_exponent() {
        assertEquals("64.0", new EvaluateExpression().evaluate("2^3^2"));
    }

    @Test
    void evaluate_complex_add() {
        assertEquals("20.0", new EvaluateExpression().evaluate("1+1+1+6+7+4"));
    }

    @Test
    void evaluate_complex_add_sequential_number(){
        assertEquals("10.0", new EvaluateExpression().evaluate("2+2+2+2+2"));
    }


    @Test
    void evaluate_complex_multiplication_sequential_number(){
        assertEquals("64.0", new EvaluateExpression().evaluate("2*2*2*2*2*2"));

    }

    @Test
    void evaluate_complex_multiplication() {
        assertEquals("8.5", new EvaluateExpression().evaluate("2*1/4+2*4"));
    }

    @Test
    void evaluate_complex_division() {
        assertEquals("2.0", new EvaluateExpression().evaluate("200/2/10/5"));
    }

    @Test
    void evaluate_complex_division_sequential_number(){
        assertEquals("0.25", new EvaluateExpression().evaluate("2/2/2/2"));
    }

    @Test
    void evaluate_complex_subtraction() {
        assertEquals("80.0", new EvaluateExpression().evaluate("200-20-50-40-10"));
    }

    @Test
    void evaluate_complex_scientific_notation() {
        assertEquals("1.000000002E9", new EvaluateExpression().evaluate("10^9+2"));
    }
    @Test
    void evaluate_negatives() {
        assertEquals("8.0", new EvaluateExpression().evaluate("2+-4+7--3"));
        // FAILS ^^
        assertEquals("1.0", new EvaluateExpression().evaluate("8-9--2"));
        assertEquals("17.0", new EvaluateExpression().evaluate("17-3+-1--2"));
    }

}