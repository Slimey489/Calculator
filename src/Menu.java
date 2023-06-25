import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
class  Menu{
    JButton launchCalculator;
    JButton launchQuiz;
    public static JFrame menuFrame;
    SpringLayout layout;
    Container contentPane;
    public JFrame menuFrame() {

        menuFrame = new JFrame();
        menuFrame.setTitle("Menu");
        launchCalculator = new JButton("Calculator");
        launchQuiz = new JButton("Quiz");
        contentPane = menuFrame.getContentPane();
        layout = new SpringLayout();
        launchQuiz.addActionListener(new Action());
        launchCalculator.addActionListener(new Action());


        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, launchCalculator, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, launchCalculator, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, launchQuiz, 0, SpringLayout.HORIZONTAL_CENTER, contentPane);
        layout.putConstraint(SpringLayout.NORTH, launchQuiz, 0, SpringLayout.VERTICAL_CENTER, contentPane);

        launchCalculator.setBackground(Color.GRAY);
        launchQuiz.setBackground(Color.GRAY);
        launchCalculator.setForeground(new Color(243, 242, 224));
        launchQuiz.setForeground(new Color(243, 242, 224));
        contentPane.setBackground(Color.DARK_GRAY);

        launchCalculator.setPreferredSize(new Dimension(100,25));
        launchQuiz.setPreferredSize(new Dimension(100,25));
        menuFrame.add(launchQuiz);
        menuFrame.add(launchCalculator);
        menuFrame.setSize(210, 210);
        menuFrame.setResizable(false);
        contentPane.setLayout(layout);
        contentPane.setVisible(true);
        menuFrame.setVisible(true);
        return menuFrame;
        }
    class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == launchCalculator) {
                Main gui = new Main();
                gui.mainFrame();
                menuFrame.dispatchEvent(new WindowEvent(menuFrame,WindowEvent.WINDOW_CLOSING));

            }if (e.getSource() == launchQuiz) {
                menuFrame.dispatchEvent(new WindowEvent(menuFrame, WindowEvent.WINDOW_CLOSING));
                Quiz quiz = new Quiz();
                quiz.quizFrame();
            }
        }
    }
}