import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Contain a method and subclasses to evaluate a string as a mathematical expression.
 */
class EvaluateExpression {
    Operators operators = new Operators();

    /**
     * Uses the order of operations to evaluate a mathematical expression.
     * @param expression the input expression that is to be evaluated.
     * @return {@code expression} the output expression.
     */
    public String evaluate(String expression) {
        Double answer = null;
        String operator;
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
                if (!expression.contains("^") && !expression.contains("/") && !expression.contains("*") && !expression.contains("-") && !expression.contains("+")){
                    return expression;
                }
                if (expression.equals("Error")){
                    return expression;
                }
                }
            // This prevents an infinite loop situation that would hang the program.
            i++;
            if (i == 10000){
                expression = "Error";
                return expression;
            }
        }
        expression = answer.toString();
        return expression;
    }
    /**
     *  See documentation for  {@code Operator} for below classes & methods.
    **/
    static class Operators implements Operator{
        FindRightSideValue rightOfOperator = new FindRightSideValue();
        FindLeftSideValue leftOfOperator = new FindLeftSideValue();
        @Override
        public String solver(String expression,String operator) {
            String expressionToReplace;
            double value2;
            double value1;
            try {
                value1 = Double.parseDouble(leftOfOperator.leftSide(expression,operator));
            } catch (Exception e) {
                expression = "Error";
                return expression;

            }

            try {
                value2 = Double.parseDouble(rightOfOperator.rightSide(expression,operator));
            } catch (Exception e) {
                expression = "Error";
                return expression;

            }
            //Switch cases for different operators
            switch (operator) {
                case "^" -> value1 = Math.pow(value1, value2);
                case "*" -> value1 *= value2;
                case "/" -> value1 /= value2;
                case "+" -> value1 += value2;
                case "-" -> value1 -= value2;
            }
            expressionToReplace = leftOfOperator.leftSide(expression,operator) + operator + rightOfOperator.rightSide(expression,operator);
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote, Double.toString(value1));
            return expression;
        }

        static class FindLeftSideValue implements Operator.FindLeftSideValue {
            public Integer getMaxValue(ArrayList<Integer> list) {
                int maximumValue = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) > maximumValue) {
                        maximumValue = list.get(i);
                    }
                }
                return maximumValue;
            }
            public String leftSide(String expression, String operator){
                String expressionToValue;
                String correctOperator;
                String leftSideValue;
                String[] arrayOfOperators = new String[]{"^","*","/","+","-"};
                ArrayList<String> operatorsInExpression = new ArrayList<>();
                ArrayList<Integer> indexOfOperators = new ArrayList<>();
                int arrayListIndexes = 0;

                expressionToValue = StringUtils.substringBefore(expression,operator);
                for (String arrayOfOperator : arrayOfOperators) {

                    if (expressionToValue.contains(arrayOfOperator)) {
                        operatorsInExpression.add(arrayOfOperator);
                        if (operatorsInExpression.size() > 1)
                            arrayListIndexes++;
                    }
                    if (!operatorsInExpression.isEmpty()) {
                        indexOfOperators.add(expressionToValue.indexOf(operatorsInExpression.get(arrayListIndexes)));
                    }
                }
                if (operatorsInExpression.isEmpty()){
                    leftSideValue = expressionToValue;
                    return leftSideValue;
                }
                indexOfOperators = (ArrayList<Integer>) indexOfOperators.stream().distinct().collect(Collectors.toList());
                //correctOperator = String.valueOf(expressionToValue.charAt(getMaxValue(indexOfOperators)));
                correctOperator = operatorsInExpression.get(indexOfOperators.indexOf(getMaxValue(indexOfOperators)));
                leftSideValue = StringUtils.substringAfter(expressionToValue, correctOperator);
                return leftSideValue;
            }
        }
        static class FindRightSideValue implements Operator.FindRightSideValue {
            public Integer getMinValue(ArrayList<Integer> list) {
                int minimumValue = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) < minimumValue) {
                        minimumValue = list.get(i);
                    }
                }
                return minimumValue;
            }
            @Override
            public String rightSide(String expression, String operator){
                String expressionToValue;
                String correctOperator;
                String rightSideValue;
                String[] arrayOfOperators = new String[]{"^","*","/","+","-"};
                ArrayList<String> operatorsInExpression = new ArrayList<>();
                ArrayList<Integer> indexOfOperators = new ArrayList<>();
                int arrayListIndexes = 0;

                expressionToValue = StringUtils.substringAfter(expression,operator);
                for (String arrayOfOperator : arrayOfOperators) {

                    if (expressionToValue.contains(arrayOfOperator)) {
                        operatorsInExpression.add(arrayOfOperator);
                        if (operatorsInExpression.size() > 1)
                            arrayListIndexes++;
                    }
                    if (!operatorsInExpression.isEmpty()) {
                        indexOfOperators.add(expressionToValue.indexOf(operatorsInExpression.get(arrayListIndexes)));
                    }
                }
                if (operatorsInExpression.isEmpty()){
                    rightSideValue = expressionToValue;
                    return rightSideValue;
                }
                indexOfOperators = (ArrayList<Integer>) indexOfOperators.stream().distinct().collect(Collectors.toList());
                correctOperator = operatorsInExpression.get(indexOfOperators.indexOf(getMinValue(indexOfOperators)));
                rightSideValue = StringUtils.substringBefore(expressionToValue, correctOperator);
                return rightSideValue;
            }
        }
    }
}