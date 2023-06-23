import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class MathsPartTest {

    @Test
    void mathsPart_basic_scientific_notation() {
        assertEquals("1.0E9", new EvaluateExpression().evaluate("10^9"));
    }

    @Test
    void mathsPart_basic_exponent() {
        assertEquals("8.0", new EvaluateExpression().evaluate("2^3"));
    }

    @Test
    void mathsPart_basic_add() {
        assertEquals("2.0", new EvaluateExpression().evaluate("1+1"));
    }

    @Test
    void mathsPart_basic_multiplication() {
        assertEquals("4.0", new EvaluateExpression().evaluate("2*2"));
    }

    @Test
    void mathsPart_basic_division() {
        assertEquals("1.0", new EvaluateExpression().evaluate("2/2"));
    }

    @Test
    void mathsPart_basic_subtraction() {
        assertEquals("0.0", new EvaluateExpression().evaluate("2-2"));
    }

    @Test
    void mathsPart_complex_exponent() {
        assertEquals("64.0", new EvaluateExpression().evaluate("2^3^2"));
    }

    @Test
    void mathsPart_complex_add() {
        assertEquals("20.0", new EvaluateExpression().evaluate("1+1+5+6+7"));
    }

    @Test
    void mathsPart_complex_add_sequential_number(){
        assertEquals("10.0", new EvaluateExpression().evaluate("2+2+2+2+2"));
    }


    @Test
    void mathsPart_complex_division_sequential_number(){
        assertEquals("64.0", new EvaluateExpression().evaluate("2*2*2*2*2*2"));

    }

    @Test
    void mathsPart_complex_multiplication() {
        assertEquals("224.0", new EvaluateExpression().evaluate("2*2*8*7"));
    }

    @Test @Disabled
    void mathsPart_complex_division() {
        assertEquals("2.0", new EvaluateExpression().evaluate("200/2/10/5"));
    }

    @Test
    void mathsPart_complex_multiplication_sequential_number(){
        assertEquals("0.25", new EvaluateExpression().evaluate("2/2/2/2"));


    }

    @Test
    void mathsPart_complex_subtraction() {
        assertEquals("80.0", new EvaluateExpression().evaluate("200-20-50-40-10"));
    }

    @Test
    void mathsPart_complex_scientific_notation() {
        assertEquals("1.000000002E9", new EvaluateExpression().evaluate("10^9+2"));
    }

}