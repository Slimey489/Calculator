import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.Objects;

/**
 * Contains everything needed to create a small quiz frame.
 */
public class Quiz {
    JFrame quizFrame;
    Container contentPane;
    JLabel expressionToGuess;
    JLabel correct;
    JLabel incorrect;
    JButton backButton;
    JTextField textField;
    String expression;
    SpringLayout layout;

    /**
     * @param min minimum value to be returned.
     * @param max  maximum value to be returned.
     * @return a random integer with minimum value "min" and maximum value "max".
     */
    int randomNumber(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /**
     * @return returns a random expression with a length of up to 5 operators.
     */
    private String createExpression() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        String[] operators = new String[]{"^","*","/","-","+"};
        while(i < randomNumber(1,4)){
            result.append(randomNumber(1, 4));
            result.append(Array.get(operators,randomNumber(0,4)));
        }
        result.append(randomNumber(1, 9));
        return result.toString();
    }

    /**
     * Creates a frame containing a text box and two labels.
     */
    public void quizFrame(){

        //Sets initial values for variables
        // and colours them.

        layout = new SpringLayout();
        quizFrame = new JFrame();
        expression = createExpression();

        expressionToGuess = new JLabel(expression);
        expressionToGuess.setForeground(Main.CREAM);
        expressionToGuess.setBackground(Color.GRAY);
        textField = new JTextField();
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);
        correct = new JLabel("Correct");
        correct.setForeground(Main.CREAM);
        incorrect = new JLabel("Incorrect");
        incorrect.setForeground(Main.CREAM);
        backButton = new JButton("Back");
        backButton.setForeground(Main.CREAM);
        backButton.setBackground(Color.GRAY);

        contentPane = quizFrame.getContentPane();
        //Sets frame size and title.
        quizFrame.setTitle("Quiz");
        quizFrame.setSize(200,200);
        //Adds action listeners.
        textField.addActionListener(new Action());
        backButton.addActionListener(new Action());
        //Sets text field size.
        textField.setPreferredSize(new Dimension(150,40));
        //Sets element vertical positioning.
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,textField,0,SpringLayout.VERTICAL_CENTER,contentPane);
        layout.putConstraint(SpringLayout.NORTH,expressionToGuess,10,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.NORTH,correct,30,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.NORTH,incorrect,30,SpringLayout.NORTH,contentPane);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER,backButton,40,SpringLayout.VERTICAL_CENTER,contentPane);
        //Sets element horizontal positioning.
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,textField,0,SpringLayout.HORIZONTAL_CENTER,contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,expressionToGuess,0,SpringLayout.HORIZONTAL_CENTER,contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,correct,0,SpringLayout.HORIZONTAL_CENTER,contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,incorrect,0,SpringLayout.HORIZONTAL_CENTER,contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,backButton,0,SpringLayout.HORIZONTAL_CENTER,contentPane);
        //Adds elements to the frame
        contentPane.add(expressionToGuess);
        contentPane.add(textField);
        contentPane.add(backButton);
        contentPane.setLayout(layout);
        contentPane.setVisible(true);
        quizFrame.setVisible(true);
        //Disables the ability to resize the window.
        quizFrame.setResizable(false);

    }

    /**
     * Defines what happens on an action event.
     */
    class Action implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == textField){
                String answer = textField.getText();
                if (!answer.contains(".")){
                    answer = answer+".0";
                }
                EvaluateExpression correctAnswer = new EvaluateExpression();
                expression = correctAnswer.evaluate(expression);
                if (Objects.equals(answer, expression)){
                    contentPane.add(correct);
                    quizFrame.revalidate();
                }else {
                    contentPane.add(incorrect);
                    quizFrame.revalidate();
                }
            }
            if (e.getSource()==backButton){
                quizFrame.dispatchEvent(new WindowEvent(quizFrame, WindowEvent.WINDOW_CLOSING));
                SwingUtilities.invokeLater(new App());
            }
        }
    }
}
