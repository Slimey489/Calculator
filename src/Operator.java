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
    interface FindLeftSideValue{
        /**
         * @param list containing all the values.
         * @return maximumValue of the list.
         */
        Integer getMaxValue(ArrayList<Integer> list);
        /**
         * @param expression From .solver()
         * @param operator That is being solved for.
         * @return leftSideValue of {@code operator}.
         */
        String leftSide(String expression,String operator);
    }
    /**
     * Finds the value on the Right side of the {@code operotor}
     */
    interface FindRightSideValue{
        /**
         * @param list containing all the values.
         * @return minimumValue of the list.
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