public interface Operator {
    /**
     * @param expression A mathematical expression.
     * @param operator The {@code operator} that is being solved for.
     * @return expression but with the first instance of {@code operator} being solved.
     */
    String solver(String expression,String operator);

    /**
     * @param expression From .solver().
     * @param operator The {@code operator} that is being solved for.
     * @return leftSide The value on the left side of {@code operator}.
     */
    String leftOfOperator(String expression, String operator);
    /**
     * @param expression From .solver()
     * @param operator The {@code operator} that is being solved for.
     * @return rightSide The value on the right side of {@code operator}.
     */
    String rightOfOperator(String expression, String operator);

}

