import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Contain a method and subclasses to evaluate a string as a mathematical expression
 */
class EvaluateExpression {
    Operators operators = new Operators();

    /**
     * Uses the order of operations to evaluate a mathematical expression
     * @param expression the input expression that is to be evaluated
     * @return expression the output expression
     * @return "Error" in case of unexpected input this will return "Error" if the loop has run 10000 times
     */
    public String evaluate(String expression) {
        Double answer = null;
        String operator = "";
        int i =0;

        while (answer == null){
            try {
                answer = Double.parseDouble(expression);
            } catch (Exception e) {
                if (expression.contains("^") || expression.contains("E")) {
                    operator = "^";
                    expression = operators.solver(expression, operator);
                }
                if (!expression.contains("^") && expression.contains("*")) {
                    operator = "*";
                    expression = operators.solver(expression, operator);
                }
                if (!expression.contains("^") && expression.contains("/")) {
                    operator = "/";
                    expression = operators.solver(expression, operator);
                }
                if (!expression.contains("^") && !expression.contains("/") && !expression.contains("*") && expression.contains("+")){
                    operator = "+";
                expression = operators.solver(expression, operator);
            }
                if (!expression.contains("^") && !expression.contains("/") && !expression.contains("*") && expression.contains("-")) {
                    operator = "-";
                    expression = operators.solver(expression, operator);
                }
                }
            i++;
            if (i == 10000){
                return "Error";
            }
        }
        expression = answer.toString();
        return expression;
    }
    static class Operators implements Operator{
        private String expressionToValue;
        private String leftSide;
        private String operatorLocation;
        private String rightSide;
        private String expressionToReplace;
        @Override
        public String solver(String expression,String operator) {
            Double value2;
            Double value1;
            try {
                value1 = Double.parseDouble(leftOfOperator(expression,operator));
            } catch (Exception e) {
                //TODO
                // Add Proper error management
                return "0.0" ;

            }

            try {
                value2 = Double.parseDouble(rightOfOperator(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }
            if (operator.equals("^")) {
                value1 = Math.pow(value1, value2);
            } else if (operator.equals("*")) {
                value1 *= value2;
            } else if (operator.equals("/")) {
                value1 /= value2;
            } else if (operator.equals("+")) {
                value1 += value2;
            } else if (operator.equals("-")) {
                value1 -= value2;
            }
            expressionToReplace = leftOfOperator(expression,operator) + operator + (rightOfOperator(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());
            return expression;
        }

        @Override
        public String leftOfOperator(String expression, String operator) {
            expressionToValue = StringUtils.substringBefore(expression,operator);

            leftSide = StringUtils.substringBefore(expressionToValue, "^");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            leftSide = StringUtils.substringBefore(expressionToValue, "*");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            leftSide = StringUtils.substringBefore(expressionToValue, "/");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            leftSide = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            leftSide = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }

            return leftSide;
        }

        @Override
        public String rightOfOperator(String expression, String operator) {
            operatorLocation = StringUtils.substringAfter(expression, operator);

            rightSide = StringUtils.substringBefore(operatorLocation, "^");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            rightSide = StringUtils.substringBefore(operatorLocation, "*");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }

            rightSide = StringUtils.substringBefore(operatorLocation, "/");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            rightSide = StringUtils.substringBefore(operatorLocation, "+");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            rightSide = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            return rightSide;
        }
    }
}