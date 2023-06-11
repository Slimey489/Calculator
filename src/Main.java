import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Main {

    private Dimension mainFrameSize;

    private Dimension buttonSize;
    public JFrame frameMain;
    SpringLayout layout;
    public JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    public JButton equalsButton,multiplicationButton,divisionButton,brackets,exponentButton,subtractionButton,additionButton;
    Container objectContainer;
    public JFrame  mainFrame(){
        frameMain = new JFrame();
        mainFrameSize = new Dimension(300,300);
        buttonSize = new Dimension(60,30);
        objectContainer = frameMain.getContentPane();
        layout = new SpringLayout();

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        equalsButton = new JButton("=");
        multiplicationButton = new JButton("x");
        divisionButton = new JButton("÷");
        brackets = new JButton("()");
        exponentButton = new JButton("^x");
        additionButton = new JButton("+");
        subtractionButton = new JButton("-");

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
        equalsButton.addActionListener(new Action());
        multiplicationButton.addActionListener(new Action());
        divisionButton.addActionListener(new Action());
        brackets.addActionListener(new Action());
        exponentButton.addActionListener(new Action());
        additionButton.addActionListener(new Action());
        subtractionButton.addActionListener(new Action());

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

        layout.putConstraint(SpringLayout.NORTH, button0, 5, SpringLayout.SOUTH, button2);
        layout.putConstraint(SpringLayout.NORTH, button1, 5, SpringLayout.SOUTH, button4);
        layout.putConstraint(SpringLayout.NORTH, button2, 5, SpringLayout.SOUTH, button5);
        layout.putConstraint(SpringLayout.NORTH, button3, 5, SpringLayout.SOUTH, button6);
        layout.putConstraint(SpringLayout.NORTH, button4, 5, SpringLayout.SOUTH, button7);
        layout.putConstraint(SpringLayout.NORTH, button5, 5, SpringLayout.SOUTH, button8);
        layout.putConstraint(SpringLayout.NORTH, button6, 5, SpringLayout.SOUTH, button9);
        layout.putConstraint(SpringLayout.NORTH, button8, 0, SpringLayout.NORTH,button7);
        layout.putConstraint(SpringLayout.NORTH, button9, 0, SpringLayout.NORTH, button7);

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


        objectContainer.setSize(mainFrameSize);
        frameMain.setSize(mainFrameSize);
        frameMain.setLayout(layout);
        frameMain.setVisible(true);
        return frameMain;
    }

        }
    }









    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }
}