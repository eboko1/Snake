package fvi.snake;

import javax.swing.*;
import java.awt.*;

class Snake extends JPanel {
     public  static  final int SCALE=32;
     public  static  final int WIDTH=20;
     public  static  final int HEIGHT=20;

    public Snake(){

      }
     public void paint(Graphics  g){
      g.setColor(color(5,50,10));
         g.fillRect(0,0,SCALE*WIDTH,SCALE*HEIGHT);
     }
    public Color color(int red,int green, int blue){
        return new Color(red,green,blue);

    }

    public static void main (String[] arg){

        JFrame f= new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(SCALE*WIDTH,SCALE*HEIGHT);
        f.setLocationRelativeTo(null);// window in the center
        f.add(new Snake());
        f.setVisible(true);

    }
}
