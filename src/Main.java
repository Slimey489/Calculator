import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
class Main {

    private Dimension mainFrameSize;

    private Dimension buttonSize;
    public JFrame frameMain;
    public static String expression;
    SpringLayout layout;
    public JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    public JButton equalsButton,multiplicationButton,divisionButton,brackets,exponentButton,subtractionButton,additionButton,decimalButton;
    public static JTextField textField;
    public JButton clearButton;
    Container objectContainer;
    public JFrame  mainFrame(){
        expression = "";
        frameMain = new JFrame();
        mainFrameSize = new Dimension(280,305);
        buttonSize = new Dimension(60,30);
        Dimension textFieldSize = new Dimension(255,80);

        Color buttonBackgroundColour = Color.GRAY;
        Color buttonForegroundColour = new Color(243, 242, 224);

        objectContainer = frameMain.getContentPane();
        layout = new SpringLayout();

        textField = new JTextField();
        button0 = new JButton("0");
        button0.setBackground(buttonBackgroundColour);
        button0.setForeground(buttonForegroundColour);
        button1 = new JButton("1");
        button1.setBackground(buttonBackgroundColour);
        button1.setForeground(buttonForegroundColour);
        button2 = new JButton("2");
        button2.setBackground(buttonBackgroundColour);
        button2.setForeground(buttonForegroundColour);
        button3 = new JButton("3");
        button3.setBackground(buttonBackgroundColour);
        button3.setForeground(buttonForegroundColour);
        button4 = new JButton("4");
        button4.setBackground(buttonBackgroundColour);
        button4.setForeground(buttonForegroundColour);
        button5 = new JButton("5");
        button5.setBackground(buttonBackgroundColour);
        button5.setForeground(buttonForegroundColour);
        button6 = new JButton("6");
        button6.setBackground(buttonBackgroundColour);
        button6.setForeground(buttonForegroundColour);
        button7 = new JButton("7");
        button7.setBackground(buttonBackgroundColour);
        button7.setForeground(buttonForegroundColour);
        button8 = new JButton("8");
        button8.setBackground(buttonBackgroundColour);
        button8.setForeground(buttonForegroundColour);
        button9 = new JButton("9");
        button9.setBackground(buttonBackgroundColour);
        button9.setForeground(buttonForegroundColour);
        equalsButton = new JButton("=");
        equalsButton.setBackground(buttonBackgroundColour);
        equalsButton.setForeground(buttonForegroundColour);
        multiplicationButton = new JButton("x");
        multiplicationButton.setBackground(buttonBackgroundColour);
        multiplicationButton.setForeground(buttonForegroundColour);
        divisionButton = new JButton("÷");
        divisionButton.setBackground(buttonBackgroundColour);
        divisionButton.setForeground(buttonForegroundColour);
        brackets = new JButton("()");
        brackets.setBackground(buttonBackgroundColour);
        brackets.setForeground(buttonForegroundColour);
        exponentButton = new JButton("^x");
        exponentButton.setBackground(buttonBackgroundColour);
        exponentButton.setForeground(buttonForegroundColour);
        additionButton = new JButton("+");
        additionButton.setBackground(buttonBackgroundColour);
        additionButton.setForeground(buttonForegroundColour);
        subtractionButton = new JButton("-");
        subtractionButton.setBackground(buttonBackgroundColour);
        subtractionButton.setForeground(buttonForegroundColour);
        decimalButton = new JButton(".");
        decimalButton.setBackground(buttonBackgroundColour);
        decimalButton.setForeground(buttonForegroundColour);
        clearButton = new JButton("CE");
        clearButton.setBackground(buttonBackgroundColour);
        clearButton.setForeground(buttonForegroundColour);

        textField.setFont(new Font("Calibri",Font.BOLD,50));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.DARK_GRAY);
        textField.setBorder(null);
        objectContainer.setBackground(Color.DARK_GRAY);

        button0.addActionListener(new Action());
        button1.addActionListener(new Action());
        button2.addActionListener(new Action());
        button3.addActionListener(new Action());
        button4.addActionListener(new Action());
        button5.addActionListener(new Action());
        button6.addActionListener(new Action());
        button7.addActionListener(new Action());
        button8.addActionListener(new Action());
        button9.addActionListener(new Action());
        decimalButton.addActionListener(new Action());
        equalsButton.addActionListener(new Action());
        multiplicationButton.addActionListener(new Action());
        divisionButton.addActionListener(new Action());
        brackets.addActionListener(new Action());
        exponentButton.addActionListener(new Action());
        additionButton.addActionListener(new Action());
        subtractionButton.addActionListener(new Action());
        clearButton.addActionListener(new Action());

        textField.setPreferredSize(textFieldSize);
        button0.setPreferredSize(buttonSize);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);
        button5.setPreferredSize(buttonSize);
        button6.setPreferredSize(buttonSize);
        button7.setPreferredSize(buttonSize);
        button8.setPreferredSize(buttonSize);
        button9.setPreferredSize(buttonSize);
        decimalButton.setPreferredSize(buttonSize);
        equalsButton.setPreferredSize(buttonSize);
        additionButton.setPreferredSize(buttonSize);
        subtractionButton.setPreferredSize(buttonSize);
        multiplicationButton.setPreferredSize(buttonSize);
        divisionButton.setPreferredSize(buttonSize);
        brackets.setPreferredSize(buttonSize);
        exponentButton.setPreferredSize(buttonSize);
        clearButton.setPreferredSize(buttonSize);

        layout.putConstraint(SpringLayout.WEST,textField,5,SpringLayout.WEST,objectContainer);
        layout.putConstraint(SpringLayout.NORTH,textField,5,SpringLayout.NORTH,objectContainer);

        layout.putConstraint(SpringLayout.WEST, button7, 5, SpringLayout.WEST, objectContainer);

        layout.putConstraint(SpringLayout.NORTH, button7, 125, SpringLayout.NORTH, objectContainer);

        layout.putConstraint(SpringLayout.WEST, button0, 0, SpringLayout.WEST, button2);
        layout.putConstraint(SpringLayout.WEST, button1, 0, SpringLayout.WEST, button7);
        layout.putConstraint(SpringLayout.WEST, button2, 5, SpringLayout.EAST, button1);
        layout.putConstraint(SpringLayout.WEST, button3, 5, SpringLayout.EAST, button2);
        layout.putConstraint(SpringLayout.WEST, button4, 0, SpringLayout.WEST, button7);
        layout.putConstraint(SpringLayout.WEST, button5, 5, SpringLayout.EAST, button4);
        layout.putConstraint(SpringLayout.WEST, button6, 5, SpringLayout.EAST, button5);
        layout.putConstraint(SpringLayout.WEST, button8, 5, SpringLayout.EAST, button7);
        layout.putConstraint(SpringLayout.WEST, button9, 5, SpringLayout.EAST, button8);
        layout.putConstraint(SpringLayout.WEST,decimalButton,0,SpringLayout.WEST,button3);
        layout.putConstraint(SpringLayout.WEST,equalsButton,5,SpringLayout.EAST,decimalButton);
        layout.putConstraint(SpringLayout.WEST,additionButton,0,SpringLayout.WEST,equalsButton);
        layout.putConstraint(SpringLayout.WEST,subtractionButton,0,SpringLayout.WEST,additionButton);
        layout.putConstraint(SpringLayout.WEST,multiplicationButton,0,SpringLayout.WEST,subtractionButton);
        layout.putConstraint(SpringLayout.WEST,divisionButton,0,SpringLayout.WEST,multiplicationButton);
        layout.putConstraint(SpringLayout.WEST,brackets,0,SpringLayout.WEST,button7);
        layout.putConstraint(SpringLayout.WEST,exponentButton,0,SpringLayout.WEST,button8);
        layout.putConstraint(SpringLayout.WEST,clearButton,0,SpringLayout.WEST,button9);


        layout.putConstraint(SpringLayout.NORTH, button0, 5, SpringLayout.SOUTH, button2);
        layout.putConstraint(SpringLayout.NORTH, button1, 5, SpringLayout.SOUTH, button4);
        layout.putConstraint(SpringLayout.NORTH, button2, 5, SpringLayout.SOUTH, button5);
        layout.putConstraint(SpringLayout.NORTH, button3, 5, SpringLayout.SOUTH, button6);
        layout.putConstraint(SpringLayout.NORTH, button4, 5, SpringLayout.SOUTH, button7);
        layout.putConstraint(SpringLayout.NORTH, button5, 5, SpringLayout.SOUTH, button8);
        layout.putConstraint(SpringLayout.NORTH, button6, 5, SpringLayout.SOUTH, button9);
        layout.putConstraint(SpringLayout.NORTH, button8, 0, SpringLayout.NORTH,button7);
        layout.putConstraint(SpringLayout.NORTH, button9, 0, SpringLayout.NORTH, button7);
        layout.putConstraint(SpringLayout.NORTH,decimalButton,0,SpringLayout.NORTH,button0);
        layout.putConstraint(SpringLayout.NORTH,equalsButton,0,SpringLayout.NORTH,button0);
        layout.putConstraint(SpringLayout.NORTH,additionButton,0,SpringLayout.NORTH,button3);
        layout.putConstraint(SpringLayout.NORTH,subtractionButton,0,SpringLayout.NORTH,button6);
        layout.putConstraint(SpringLayout.NORTH,multiplicationButton,0,SpringLayout.NORTH,button9);
        layout.putConstraint(SpringLayout.SOUTH,divisionButton,-5,SpringLayout.NORTH,multiplicationButton);
        layout.putConstraint(SpringLayout.SOUTH,brackets,-5,SpringLayout.NORTH,button7);
        layout.putConstraint(SpringLayout.SOUTH,exponentButton,-5,SpringLayout.NORTH,button8);
        layout.putConstraint(SpringLayout.SOUTH,clearButton,-5,SpringLayout.NORTH,button9);

        objectContainer.add(textField);
        objectContainer.add(button0);
        objectContainer.add(button1);
        objectContainer.add(button2);
        objectContainer.add(button3);
        objectContainer.add(button4);
        objectContainer.add(button5);
        objectContainer.add(button6);
        objectContainer.add(button7);
        objectContainer.add(button8);
        objectContainer.add(button9);
        objectContainer.add(equalsButton);
        objectContainer.add(additionButton);
        objectContainer.add(subtractionButton);
        objectContainer.add(multiplicationButton);
        objectContainer.add(divisionButton);
        //objectContainer.add(brackets);
        objectContainer.add(exponentButton);
        objectContainer.add(decimalButton);
        objectContainer.add(clearButton);


        objectContainer.setSize(mainFrameSize);
        frameMain.setResizable(false);
        frameMain.setSize(mainFrameSize);
        frameMain.setLayout(layout);
        frameMain.setVisible(true);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frameMain;
    }
    private class Action implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button0) {
                expression = textField.getText() + 0;
                textField.setText(expression);
            } else if (e.getSource() == button1) {
                expression = textField.getText() + 1;
                textField.setText(expression);
            } else if (e.getSource() == button2) {
                expression = textField.getText() + 2;
                textField.setText(expression);
            } else if (e.getSource() == button3) {
                expression = textField.getText() + 3;
                textField.setText(expression);
            } else if (e.getSource() == button4) {
                expression = textField.getText() + 4;
                textField.setText(expression);
            } else if (e.getSource() == button5) {
                expression = textField.getText() + 5;
                textField.setText(expression);
            } else if (e.getSource() == button6) {
                expression = textField.getText() + 6;
                textField.setText(expression);
            } else if (e.getSource() == button7) {
                expression = textField.getText() + 7;
                textField.setText(expression);
            } else if (e.getSource() == button8) {
                expression = textField.getText() + 8;
                textField.setText(expression);
            } else if (e.getSource() == button9) {
                expression = textField.getText() + 9;
                textField.setText(expression);
            }
            if (e.getSource() == brackets) {
                expression = textField.getText() + "()";
                textField.setText(expression);
            } else if (e.getSource() == multiplicationButton) {
                expression = textField.getText() + "*";
                textField.setText(expression);
            } else if (e.getSource() == divisionButton) {
                expression = textField.getText() + "/";
                textField.setText(expression);
            } else if (e.getSource() == additionButton) {
                expression = textField.getText() + "+";
                textField.setText(expression);
            } else if (e.getSource() == subtractionButton) {
                expression = textField.getText() + "-";
                textField.setText(expression);
            } else if (e.getSource() == exponentButton) {
                expression = textField.getText() + "^";
                textField.setText(expression);
            } else if (e.getSource() == equalsButton){
                expression = textField.getText();
                //TODO VVVV
                //if (expression.matches("[\\d?\\\\*?\\\\+?\\-?\\\\/?\\\\^?\\\\E]")){
                    textField.setText(new EvaluateExpression().evaluate(expression));
               // }else{
                    //textField.setText("Error");
                //}


            } else if (e.getSource() == decimalButton) {
                expression = textField.getText()+".";
                textField.setText(expression);
            } else if (e.getSource() == clearButton) {
                textField.setText("");
                expression = textField.getText();

            }

            System.out.println(expression);

        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }
}
class EvaluateExpression {
    Exponents exponents = new Exponents();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();

    public String evaluate(String expression) {
        Double answer = null;

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

        }
        return expression;
    }
    static class Exponents{
        private String expressionToValue;
        private String leftSide;
        private String operatorLocation;
        private String rightSide;
        private String expressionToReplace;
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

            return leftValue;
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
                value2 = Double.parseDouble(leftSideSubtraction(expression,operator));
            } catch (Exception e) {
                return "0.0" ;

            }

            try {
                value1 = Double.parseDouble(rightSideSubtraction(expression,operator));
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
