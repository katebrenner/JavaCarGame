import processing.core.PApplet;

public class Game {
    PApplet p;
    String mState;
    int roadX = 50;
    Game(PApplet p, String State){
        this.p = p;
        mState = State;
    }
    public void render() {
        //rendering
        p.background(124,252,0);
//        p.stroke(100, 100, 100);
        p.fill(100,100,100);
        p.rect(0, 200, 1024, 400);
        p.fill(255, 255, 0);
//        while(mState == "go") {
////            int i = 1;
////            p.rect(i + roadX, 200, 50, 10);
////            p.rect(i + roadX, 600, 50, 10);
////            i = i + 100;
////          System.out.println("go");

//        }
        for (int i = 1; i < 1000000; i = i + 100) {
            p.rect(i + roadX, 400, 50, 10);
        }
        //logic
        roadX = roadX - 1;
    }
    public String getmState() {
        return mState;
    }

    public void wrongInput() {
        p.text(" Please use A for player one and L for player 2", 700, 120);
    }
//    public void setmState() {
//        if( mState == "wait") {
//            mState = "go";
//        }
//        else if (mState == "go") {
//            mState = "wait";
//        }
//    }
}
