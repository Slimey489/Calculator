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
            }
            catch (Exception e) {
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
                if (!expression.contains("^") && !expression.contains("/") && !expression.contains("*") && expression.contains("-") && (!operators.negative||expression.contains("--"))) {
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
        public boolean negative;
        @Override
        public String solver(String expression,String operator) {
            String expressionToReplace;
            double value2;
            double value1;
            // Attempts to parse the return value of leftOfOperator.leftSide as a double.
            // Else return "Error"
            try {
                value1 = Double.parseDouble(leftOfOperator.leftSide(expression,operator));
            } catch (Exception e) {
                expression = "Error";
                return expression;

            }
            // Attempts to parse the return value of rightOfOperator.rightSide as a double.
            // Else return "Error"
            try {
                value2 = Double.parseDouble(rightOfOperator.rightSide(expression,operator,false));
            } catch (Exception e) {
                expression = "Error";
                return expression;

            }
            // Gets the expression that will be replaced by its result.
            expressionToReplace = leftOfOperator.leftSide(expression,operator) + operator + rightOfOperator.rightSide(expression,operator,false);
            // Creates regex matching the expression that will be replaced
            String quote = Pattern.quote(expressionToReplace);
            if (negative){
                value1 = value1 * -1;
                negative = false;
            }
            //Switch cases for different operators
            switch (operator) {
                case "^" -> value1 = Math.pow(value1, value2);
                case "*" -> value1 *= value2;
                case "/" -> value1 /= value2;
                case "+" -> value1 += value2;
                case "-" -> value1 -= value2;
            }
            // Replaces the part of the expression that was solved with the result for that expression.
            expression = RegExUtils.replaceFirst(expression,quote, Double.toString(value1));
            if (expression.indexOf("-") == 0){
                negative = true;
                expression = RegExUtils.removeFirst(expression,"-");
            }
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
            public String leftSide(String expression, String operator) {
                FindRightSideValue rightOfOperator = new FindRightSideValue();
                String expressionToValue;
                String correctOperator;
                String leftSideValue;
                String[] arrayOfOperators = new String[]{"^", "*", "/", "+", "-"};
                ArrayList<String> operatorsInExpression = new ArrayList<>();
                ArrayList<Integer> indexOfOperators = new ArrayList<>();
                int arrayListIndexes = 0;

                expressionToValue = StringUtils.substringBefore(expression, operator);

                if (expressionToValue.equals("")) {
                    leftSideValue = rightOfOperator.rightSide(expression, operator, true);
                    return leftSideValue;
                }
                // This loops through the expression on the left side of the operator, then
                // gets the operators and what indexes they are at the puts them into two ArrayLists.
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
                if (operatorsInExpression.isEmpty()) {
                    leftSideValue = expressionToValue;
                    return leftSideValue;
                }
                // Filters all unique operators in the Arraylist and their indexes.
                indexOfOperators = (ArrayList<Integer>) indexOfOperators.stream().distinct().collect(Collectors.toList());
                // Finds the operator with the highest index
                correctOperator = operatorsInExpression.get(indexOfOperators.indexOf(getMaxValue(indexOfOperators)));
                if (expressionToValue.indexOf("-") == 0){
                    leftSideValue = expressionToValue;
                }else {
                    // Finds the value after the correctOperator
                    leftSideValue = StringUtils.substringAfter(expressionToValue, correctOperator);
                }
                return leftSideValue;
            }
        }
        static class FindRightSideValue implements Operator.FindRightSideValue {
            public Integer getMinValue(ArrayList<Integer> list) {
                int minimumValue = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    if ((list.get(i) < minimumValue) && !(list.get(i) == 0)) {
                        minimumValue = list.get(i);
                    }
                }
                return minimumValue;
            }
            @Override
            public String rightSide(String expression, String operator,boolean negative){
                String expressionToValue;
                String correctOperator;
                String rightSideValue;
                String[] arrayOfOperators = new String[]{"^","*","/","+","-"};
                ArrayList<String> operatorsInExpression = new ArrayList<>();
                ArrayList<Integer> indexOfOperators = new ArrayList<>();
                int arrayListIndexes = 0;

                expressionToValue = StringUtils.substringAfter(expression,operator);
                if(expressionToValue.indexOf("-") == 0){
                    expressionToValue = RegExUtils.removeFirst(expressionToValue,"-");
                    negative = true;
                }
                // This loops through the expression on the right side of the operator, then
                // gets the operators and what indexes they are at the puts them into two ArrayLists.
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
                    if (negative){
                        rightSideValue = "-" + expressionToValue;
                    }
                    return rightSideValue;
                }
                // Filters all unique operators in the Arraylist and their indexes.
                indexOfOperators = (ArrayList<Integer>) indexOfOperators.stream().distinct().collect(Collectors.toList());
                // Finds the operator with the lowest index
                correctOperator = operatorsInExpression.get(indexOfOperators.indexOf(getMinValue(indexOfOperators)));
                // Finds the value before the correctOperator
                rightSideValue = StringUtils.substringBefore(expressionToValue, correctOperator);
                // If the value is a negative this adds a leading - to rightSideValue
                if (negative){
                    rightSideValue = "-" + rightSideValue;
                }
                boolean indexIs0 = 0 == getMinValue(indexOfOperators);

               if ((correctOperator.equals("-") && indexIs0 ) && StringUtils.countMatches(expressionToValue,"-") == 1){
                    rightSideValue = expressionToValue;
                }
                return rightSideValue;
            }
        }
    }
}