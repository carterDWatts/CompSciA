import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] atr){
        JFrame frame = new JFrame("Help");
        Canvas snowman = new Snowman();
        snowman.setSize(300,225);
        frame.add(snowman);
        frame.pack();
        frame.setVisible(true);
       
    }
}