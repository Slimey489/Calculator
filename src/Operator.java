public interface Operator {
    String solver(String expression);
    String leftOfOperator(String expression, String operator);
    String rightOfOperator(String expression, String operator);

}

