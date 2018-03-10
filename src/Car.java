import processing.core.PApplet;

import static sun.plugin2.main.client.MacOSXKeyHandler.isKeyDown;
import java.awt.event.KeyEvent;


public class Car {
    PApplet p;
    String mName = "name";
    int mStroke = 255;
    int mFill = 128;
    int mY = 100;
    int mX = 100;
    char mKey = 26;
    int mScore = 0;

    Car(PApplet p, String Name, int Stroke, int Fill, int Y, int X, char Key, int Score){
       this.p = p;
       mName = Name;
       mStroke = Stroke;
       mFill = Fill;
       mY = Y;
       mX = X;
       mKey = Key;
       mScore = Score;
   }

   public void render(){
       p.stroke(mStroke);
       p.fill(mFill);
       p.rect(mX, mY,100,100);

   }

    public void keyPressed() {
        mX = mX + 50;
        if (mX == 1000) {
            System.out.println("winner is" + mName);
            mScore = mScore + 1;
        }
    }

    public int getScore() {
        return mScore;
    }
    public int getmX() {
        return mX;
    }

//    public void setmScore() {
//        mScore = mScore + 1;
//    }

    public void setmX() {
    mX = 100;
    }
}



