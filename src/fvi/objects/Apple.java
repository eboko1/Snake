package fvi.objects;

/**
 * Created by Vika on 01.11.2016.
 */
public class Apple {
    Snake main;

    public int posX;
    public int posY;


    public Apple(int startX, int startY){
        posX=startX;
        posY=startY;
    }
@SuppressWarnings("static-access")
    public void setRandomPosition(){
        posX=(int)(Math.random()*main.WIDTH);
        posY=(int)(Math.random()*main.WIDTH);
    }
}
