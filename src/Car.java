import processing.core.PApplet;
import processing.core.PImage;

public class Car {
    PApplet p;
    PImage webImg;
    String mName = "name";
    int mStroke = 255;
    int mFill = 128;
    int mY = 100;
    int mX = 100;
    char mKey = 26;
    int mScore = 0;

    Car(PApplet p, PImage image, String Name, int Y, int X, char Key, int Score){
       this.p = p;
       this.webImg = image;
       mName = Name;
       mY = Y;
       mX = X;
       mKey = Key;
       mScore = Score;
   }

   void setup() {

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
            mScore = mScore + 1;
        }
    }

    public int getScore() {
        return mScore;
    }
    public int getmX() {
        return mX;
    }
//    public void setWidth(int x) {
//        mWidth = x;
//    }
//    public int getmWidth() {
//        return mWidth;
//    }

//    public void setmScore() {
//        mScore = mScore + 1;
//    }

    public void setmX() {
    mX = 100;
    }
}



