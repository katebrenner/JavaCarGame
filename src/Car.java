import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

import static processing.core.PApplet.parseInt;

public class Car {
    PApplet p;
    PImage webImg;
    String mName = "name";
    int mStroke = 255;
    int mFill = 128;
    int mY = 100;
    int mX = 100;
    char mKey = 26;
    private ArrayList<Integer> mScore = new ArrayList<>();

    Car(PApplet p, PImage image, String Name, int Y, int X, char Key){
       this.p = p;
       this.webImg = image;
       mName = Name;
       mY = Y;
       mX = X;
       mKey = Key;
   }

   public void render(){
       p.stroke(mStroke);
       p.fill(mFill);
       p.image(webImg, mX, mY);
   }
    public void keyPressed() {
        mX = mX + 10;
        if (mX == 1000) {
            System.out.println("winner is" + mName);
            mScore.add(1);
        }
    }
    public int getScore() {
        int sum = 0;
        if( mScore.size() > 0 ) {
            for (int i : mScore) {
                sum = sum + i;
            }
        }
        return sum;
    }
    public int getmX() {
        return mX;
    }
    public void setmX() {
        mX = 100;
    }
}



