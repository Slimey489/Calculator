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
         * @param expression the input expression containing the caret character
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
         * @param expression the input expression containing the asterisk character
         * @return expression same as input but with first multiplication being solved
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
         * @param expression
         * @param operator
         * @return
         */
        public String leftSideMultiplication(String expression, String operator){

            operatorLocation = StringUtils.substringBefore(expression, operator);
            if( !operatorLocation.contains("*")&!operatorLocation.contains("/")&!operatorLocation.contains("-")&!operatorLocation.contains("+"))
                return operatorLocation;
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

        public String rightSideMultiplication(String expression, String operator){
            expressionToValue = StringUtils.substringAfter(expression,operator);
            if( !expressionToValue.contains("*")&!expressionToValue.contains("/")&!expressionToValue.contains("-")&!expressionToValue.contains("+"))
                return expressionToValue;
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



        public String leftSideDivision(String expression, String operator){

            operatorLocation = StringUtils.substringBefore(expression, operator);
            if (!operatorLocation.contains("/")&!operatorLocation.contains("-")&operatorLocation.contains("+")){
                return operatorLocation;
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
        public String leftSideSubtraction(String expression, String operator){
            operatorLocation = StringUtils.substringBefore(expression, operator);

            leftValue = StringUtils.substringBefore(operatorLocation, "-");
            if (!Objects.equals(leftValue, operatorLocation)){
                return leftValue;
            }
            return leftValue;
        }

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