import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Contain a method and subclasses to evaluate a string as a mathematical expression
 */
class EvaluateExpression {

    Exponents exponents = new Exponents();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();

    /**
     * Uses the order of operations to evaluate a mathematical expression
     * @param expression the input expression that is to be evaluated
     * @return expression the output expression
     * @return "Error" in case of unexpected input this will return "Error" if the loop has run 10000 times
     */
    public String evaluate(String expression) {
        Double answer = null;
        int i =0;

        while (answer == null){
            try {
                answer = Double.parseDouble(expression);
            } catch (Exception e){
                if (expression.contains("^")|expression.contains("E"))
                    expression = exponents.solver(expression);
                if (!expression.contains("^") & expression.contains("*"))
                    expression = multiplication.solver(expression);
                if (!expression.contains("^") & expression.contains("/"))
                    expression = division.solver(expression);
                if (!expression.contains("^") & !expression.contains("/") & !expression.contains("*") & expression.contains("+"))
                    expression = addition.solver(expression);
                if (!expression.contains("^") & !expression.contains("/") & !expression.contains("*") & expression.contains("-"))
                    expression = subtraction.solver(expression);
            }
            i++;
            if (i == 10000){
                return "Error";
            }
        }
        return expression;
    }

    static class Exponents{
        private String expressionToValue;
        private String leftSide;
        private String operatorLocation;
        private String rightSide;
        private String expressionToReplace;

        /**
         * @param expression the input expression containing the caret "^" character
         * @return expression   same as input but with first exponent being solved
         * @error_return 0.0 returns 0.0 in case the return value of either leftSideExponents or rightSideExponents fails to parse a double
         */
        public String solver(String expression) {
            Double value2;
            Double value1;
            String operator = "^";
            try {
                value1 = Double.parseDouble(leftSideExponents(expression,operator));
            } catch (Exception e) {
                //TODO
                // Add Proper error management
                return "0.0" ;

            }

            try {
                value2 = Double.parseDouble(rightSideExponents(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }
            value1 = Math.pow(value1, value2);
            expressionToReplace = leftSideExponents(expression,operator) + operator + (rightSideExponents(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());



            return expression;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String leftSideExponents(String expression, String operator){

            expressionToValue = StringUtils.substringBefore(expression,operator);

            leftSide = StringUtils.substringBefore(expressionToValue, "-");
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
            leftSide = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            leftSide = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(leftSide, expressionToValue)){
                return leftSide;
            }
            return leftSide;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String rightSideExponents(String expression, String operator){

            operatorLocation = StringUtils.substringAfter(expression, operator);

            rightSide = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            rightSide = StringUtils.substringBefore(operatorLocation, "^");
            if (!Objects.equals(rightSide, operatorLocation)){
                return rightSide;
            }
            rightSide = StringUtils.substringBefore(operatorLocation, "+");
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

            return rightSide;
        }
    }


    static class Multiplication{
        private String leftValue;
        private String expressionToValue;
        private String operatorLocation;
        private String rightValue;
        /**
         * @param expression the input expression containing the asterisk "*" character
         * @return expression same as input but with first multiplication problem being solved
         * @error_return 0.0 returns 0.0 in case the return value of either leftSideMultiplication or rightSideMultiplication fails to parse a double
         */
        public String solver(String expression) {
            Double value2;
            Double value1;
            String operator = "*";
            try {
                value1 = Double.parseDouble(leftSideMultiplication(expression,operator));
            } catch (Exception e) {
                return "0.0" ;

            }

            try {
                value2 = Double.parseDouble(rightSideMultiplication(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }

            value1 *=  value2;
            String expressionToReplace = leftSideMultiplication(expression,operator) + operator + (rightSideMultiplication(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());


            return expression;
        }

        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String leftSideMultiplication(String expression, String operator){

            operatorLocation = StringUtils.substringBefore(expression, operator);
            if( !operatorLocation.contains("*")&!operatorLocation.contains("/")&!operatorLocation.contains("-")&!operatorLocation.contains("+")){
                leftValue = operatorLocation;
                return leftValue;
            }
            leftValue = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            leftValue = StringUtils.substringBefore(operatorLocation, "/");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(leftValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "*");
            if (!Objects.equals(leftValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "^");
            if (!Objects.equals(leftValue, expressionToValue)){
                return rightValue;
            }

            return rightValue;
        }

        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String rightSideMultiplication(String expression, String operator){
            expressionToValue = StringUtils.substringAfter(expression,operator);
            if( !expressionToValue.contains("*")&!expressionToValue.contains("/")&!expressionToValue.contains("-")&!expressionToValue.contains("+")) {
                rightValue = expressionToValue;
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "/");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "*");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "^");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            return rightValue;
        }
    }
    static class Division{
        private String leftValue;
        private String expressionToValue;
        private String operatorLocation;
        private String rightValue;
        /**
         * @param expression the input expression containing the slash "/" character
         * @return expression same as input but with first division problem being solved
         * @error_return 0.0 returns 0.0 in case the return value of either leftSideDivision or rightSideDivision fails to parse a double
         */
        public String solver(String expression) {
            Double value2;
            Double value1;
            String operator = "/";
            try {
                value1 = Double.parseDouble(leftSideDivision(expression,operator));
            } catch (Exception e) {
                return "0.0" ;

            }

            try {
                value2 = Double.parseDouble(rightSideDivision(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }
            value1 /=  value2;
            String expressionToReplace = leftSideDivision(expression,operator) + operator + (rightSideDivision(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());

            return expression;
        }


        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String leftSideDivision(String expression, String operator){

            operatorLocation = StringUtils.substringBefore(expression, operator);
            if (!operatorLocation.contains("/")&!operatorLocation.contains("-")&operatorLocation.contains("+")){
                leftValue = operatorLocation;
                return leftValue;
            }

            leftValue = StringUtils.substringBefore(operatorLocation, "/");
            if (!Objects.equals(leftValue,operatorLocation)){
                return leftValue;
            }

            leftValue = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            leftValue = StringUtils.substringBefore(operatorLocation, "+");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }

            return leftValue;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return rightValue the numerical value on the right side of the operator
         */
        public String rightSideDivision(String expression, String operator){
            expressionToValue = StringUtils.substringAfter(expression,operator);

            rightValue = StringUtils.substringBefore(expressionToValue, "/");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }

            rightValue = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }

            rightValue = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            return rightValue;
        }
    }
    static class Addition{
        private String leftValue;
        private String expressionToValue;
        private String operatorLocation;
        private String rightValue;
        /**
         * @param expression the input expression containing the plus "+" character
         * @return expression same as input but with first addition problem being solved
         * @error_return 0.0 returns 0.0 in case the return value of either leftSideAddition or rightSideAddition fails to parse a double
         */
        public String solver(String expression) {
            Double value2;
            Double value1;
            String operator = "+";
            try {
                value2 = Double.parseDouble(leftSideAddition(expression,operator));
            } catch (Exception e) {
                return "0.0" ;

            }

            try {
                value1 = Double.parseDouble(rightSideAddition(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }
            value1 +=  value2;
            String expressionToReplace = leftSideAddition(expression, operator) + operator + (rightSideAddition(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());
            return expression;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String leftSideAddition(String expression, String operator){

            operatorLocation = StringUtils.substringBefore(expression, operator);

            leftValue = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            leftValue = StringUtils.substringBefore(operatorLocation, "+");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            return leftValue;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return rightValue the numerical value on the right side of the operator
         */
        public String rightSideAddition(String expression,String operator){
            expressionToValue = StringUtils.substringAfter(expression,operator);

            rightValue = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            rightValue = StringUtils.substringBefore(expressionToValue, "+");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            return rightValue;
        }
    }
    static class Subtraction{
        private String leftValue;
        private String expressionToValue;
        private String operatorLocation;
        private String rightValue;
        /**
         * @param expression the input expression containing the hyphen "-" character
         * @return expression same as input but with first subtraction problem being solved
         * @error_return 0.0 returns 0.0 in case the return value of either leftSideSubtraction or rightSideSubtraction fails to parse a double
         */
        public String solver(String expression) {
            Double value2;
            Double value1;
            String operator = "-";
            try {
                value1 = Double.parseDouble(leftSideSubtraction(expression,operator));
            } catch (Exception e) {
                return "0.0" ;

            }

            try {
                value2 = Double.parseDouble(rightSideSubtraction(expression,operator));
            } catch (Exception e) {
                return "0.0";

            }
            value1 -=  value2;
            String expressionToReplace = leftSideSubtraction(expression,operator) + operator + (rightSideSubtraction(expression,operator));
            String quote = Pattern.quote(expressionToReplace);
            expression = RegExUtils.replaceFirst(expression,quote,value1.toString());

            return expression;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return leftValue the numerical value on the left side of the operator
         */
        public String leftSideSubtraction(String expression, String operator){
            operatorLocation = StringUtils.substringBefore(expression, operator);

            leftValue = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            return leftValue;
        }
        /**
         * @param expression the input expression
         * @param operator the operator being used to find the correct value
         * @return rightValue the numerical value on the right side of the operator
         */
        public String rightSideSubtraction(String expression, String operator){
            expressionToValue = StringUtils.substringAfter(expression,operator);

            rightValue = StringUtils.substringBefore(expressionToValue, "-");
            if (!Objects.equals(rightValue, expressionToValue)){
                return rightValue;
            }
            return rightValue;
        }
    }
}