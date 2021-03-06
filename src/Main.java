
import javax.swing.*;
import java.awt.*;


public class Main extends JFrame implements Runnable{

    private  PingAnalyzer pingAnalyzer;
    public static void main(String[] args){
       new Main().init();

    }

    public void init(){
        Dimension size = new Dimension(700, 500);
        this.setSize(size);
        this.setPreferredSize(size);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        pingAnalyzer = new PingAnalyzer("Ping Time ms");

        this.add(pingAnalyzer);
        this.pack();
        this.setLocationRelativeTo(null);
        this.revalidate();

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
