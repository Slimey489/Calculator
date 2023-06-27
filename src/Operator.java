import java.util.ArrayList;

/**
 * Contains Methods that deconstruct and evaluate a mathematical expression.
 */
 interface Operator {
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
     * Finds the value on the Right side of the {@code operotor}
     */
    interface FindRightSideValue{
        /**
         * @param list containing all the values.
         * @return minValue of the list.
         */
        Integer getMinValue(ArrayList<Integer> list);
        /**
         * @param expression From .solver()
         * @param operator That is being solved for.
         * @return rightSideValue of {@code operator}.
         */
        String rightSide(String expression,String operator);
    }

}