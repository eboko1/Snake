package fvi.snake;

import fvi.objects.SnakeS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Snake extends JPanel implements ActionListener {
     public  static  final int SCALE=32;
     public  static  final int WIDTH=20;
     public  static  final int HEIGHT=20;
    public  static  final int SPEED=5;

    SnakeS s = new SnakeS(10,10,9,10);// class SnakeS

    Timer t = new Timer(1000/SPEED,this);

    public Snake(){
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }

    public void paint(Graphics  g){
         g.setColor(color(5,50,10));
         g.fillRect(0,0,SCALE*WIDTH,SCALE*HEIGHT);
         g.setColor(color(255,216,0));

         for(int xx=0; xx<=WIDTH*SCALE; xx+=SCALE){
            g.drawLine(xx,0,xx,WIDTH*SCALE);
         }

         for(int yy=0; yy<HEIGHT*SCALE; yy+=SCALE){
             g.drawLine(0,yy,HEIGHT*SCALE,yy);
         }
         for (int d=0; d<s.length;d++){
             g.setColor(color(20,0,150));
            g.fillRect(s.snakeX[d]*SCALE+1,s.snakeY[d]*SCALE+1,SCALE-1, SCALE-1);
         }
     }
    public Color color(int red,int green, int blue){
        return new Color(red,green,blue);

    }

    public static void main (String[] arg){

        JFrame f= new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(SCALE*WIDTH+7,SCALE*HEIGHT+30);
        f.setLocationRelativeTo(null);// window in the center
        f.add(new Snake());
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent kE){
            int key = kE.getKeyCode();
            if ((key == KeyEvent.VK_RIGHT) & s.direction!=2) s.direction=0;
            if ((key == KeyEvent.VK_DOWN)& s.direction!=3) s.direction=1;
            if ((key == KeyEvent.VK_LEFT)& s.direction!=0) s.direction=2;
            if ((key == KeyEvent.VK_UP) & s.direction!=1) s.direction=3;
        }
    }
}
