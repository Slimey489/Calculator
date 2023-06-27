/**
 * Contains Methods that deconstruct and evaluate a mathematical expression.
 */
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

    public interface RightOfOperator{
        /**
         * @param expression From .solver()
         * @param operator The {@code operator} that is being solved for.
         * @return rightSide The value on the right side of {@code operator}.
         */
        String caret(String expression);
        /**
         * @param expression From .solver()
         * @return rightSide The value on the right side of {@code operator}.
         */
        String aestrix(String expression);
        /**
         * @param expression From .solver()
         * @return rightSide The value on the right side of {@code operator}.
         */
        String slash(String expression);
        /**
         * @param expression From .solver()
         * @return rightSide The value on the right side of {@code operator}.
         */
        String plus(String expression);
        /**
         * @param expression From .solver()
         * @return rightSide The value on the right side of {@code operator}.
         */
        String dash(String expression);
    }

}