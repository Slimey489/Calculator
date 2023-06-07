import javax.swing.*;

public class App implements Runnable {
    private JFrame gui;
    public void run(){
            Main classInstance = new Main();
            gui = classInstance.mainFrame();

    }
}
