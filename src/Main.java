import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.lang3.StringUtils;
class Main {

    public JFrame frameMain;
    public static String expression;
    SpringLayout layout;
    public JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    public JButton equalsButton,multiplicationButton,divisionButton,brackets,exponentButton,subtractionButton,additionButton,decimalButton;
    public JButton backButton;
    public static JTextField textField;
    public JButton clearButton;
    public static final Color CREAM = new Color(243, 242, 224);

    Container objectContainer;

    /**
     * Creates calculator GUI with the operators ^ * / - +
     * now with custom colours
     */
    public void mainFrame(){
        expression = "";

        //Sets element sizes and colours
        frameMain = new JFrame();

        //Sets frame title
        frameMain.setTitle("Calculator");

        //Setting mainFrame size
        Dimension mainFrameSize = new Dimension(280, 305);

        //Sets button size variable
        Dimension buttonSize = new Dimension(60, 30);

        //Sets text field size
        Dimension textFieldSize = new Dimension(255,80);

        //Sets colour variables
        Color buttonBackgroundColour = Color.GRAY;
        Color buttonForegroundColour = Main.CREAM;

        //Setting objectContainer value
        objectContainer = frameMain.getContentPane();

        //Sets layout
        layout = new SpringLayout();
        textField = new JTextField();

        //Sets button colours and text
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
        backButton = new JButton("<--");
        backButton.setBackground(buttonBackgroundColour);
        backButton.setForeground(buttonForegroundColour);

        //Sets up the text field with custom font and colours
        textField.setFont(new Font("Calibre",Font.BOLD,50));
        textField.setForeground(Color.WHITE);
        textField.setBackground(Color.DARK_GRAY);
        //Removes text field border
        textField.setBorder(null);
        //Sets frame colour
        objectContainer.setBackground(Color.DARK_GRAY);

        //Adds button press functionality
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
        backButton.addActionListener(new Action());
        textField.addActionListener(new Action());

        //Setting element sizes
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
        backButton.setPreferredSize(buttonSize);

        // Sets UI element positioning
        //Sets text field position
        layout.putConstraint(SpringLayout.WEST,textField,5,SpringLayout.WEST,objectContainer);
        layout.putConstraint(SpringLayout.NORTH,textField,5,SpringLayout.NORTH,objectContainer);

        //Change this to move overall ui horizontal positioning
        layout.putConstraint(SpringLayout.WEST, button7, 5, SpringLayout.WEST, objectContainer);

        //Change this to move overall ui vertical positioning
        layout.putConstraint(SpringLayout.NORTH, button7, 125, SpringLayout.NORTH, objectContainer);

        //Horizontal Positioning
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
        layout.putConstraint(SpringLayout.WEST,backButton,0,SpringLayout.WEST,button7);

        //Vertical Positioning
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
        layout.putConstraint(SpringLayout.SOUTH,backButton,-5,SpringLayout.NORTH,button7);

        // adds the UI elements to the contentpane

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
        objectContainer.add(backButton);

        //Setting frame size
        objectContainer.setSize(mainFrameSize);
        frameMain.setSize(mainFrameSize);

        //Makes the window not resizeable
        frameMain.setResizable(false);

        //Setting frame layout
        frameMain.setLayout(layout);

        //Makes the elements visible
        frameMain.setVisible(true);

        //Makes program exit on window close
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Defines actions to be performed when specific buttons are pressed
     */
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
            } else if (e.getSource() == equalsButton) {
                expression = textField.getText();
                if (!StringUtils.containsAny(expression, "abcdefghijlmnopqrstuvwxyz!@#$%&(){}[]\\|:;,?_\"=")) {
                    textField.setText(new EvaluateExpression().evaluate(expression));
                } else {
                    textField.setText("Error");
                }
            }else if (e.getSource() == textField){
                    expression = textField.getText();
                    if (!StringUtils.containsAny(expression,"abcdefghijlmnopqrstuvwxyz!@#$%&(){}[]\\|:;,?_\"=")){
                        textField.setText(new EvaluateExpression().evaluate(expression));
                    }else{
                        textField.setText("Error");
                    }
            } else if (e.getSource() == decimalButton) {
                expression = textField.getText()+".";
                textField.setText(expression);
            } else if (e.getSource() == clearButton) {
                textField.setText("");
                expression = textField.getText();

            } else if (e.getSource() == backButton) {
                SwingUtilities.invokeLater(new App());
                frameMain.dispose();
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }
}