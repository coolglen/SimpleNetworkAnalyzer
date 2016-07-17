import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{

    public Graphics g;
    public Screen(JFrame frame){
        this.setSize(frame.getSize());
        this.setVisible(true);

    }

    protected void draw(){
        this.g = super.getGraphics();
        System.out.println("draw");
        g.drawRect(10,10,10,10);
        g.dispose();
    }
}
