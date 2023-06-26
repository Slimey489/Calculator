public interface Operator {
    String solver(String expression,String operator);
    String leftOfOperator(String expression, String operator);
    String rightOfOperator(String expression, String operator);

}

