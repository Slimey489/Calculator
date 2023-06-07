import javax.swing.*;
import java.awt.*;

public class Main {

    private Dimension mainFrameSize;
    public JFrame frameMain;
    public JFrame  mainFrame(){
        frameMain = new JFrame();
        mainFrameSize = new Dimension(300,300);
        frameMain.setPreferredSize(mainFrameSize);
        frameMain.setVisible(true);
        return frameMain;
    }










    public static void main(String[] args) {
        SwingUtilities.invokeLater(new App());
    }
}