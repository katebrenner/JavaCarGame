import processing.core.PApplet;

public class Game {
    PApplet p;
    String mState = "go";
    int roadX = 50;
    Game(PApplet p, String State){
        this.p = p;
        mState = State;
    }

    public void render() {
        roadX = roadX - 1;
        p.background(124,252,0);
        p.stroke(100, 100, 100);
        p.fill(100,100,100);
        p.rect(0, 100, 1024, 200);
        p.rect(0, 500, 1024, 200);
        p.rect(0, 100, 1024, 200);
        p.rect(0, 500, 1024, 200);
        p.stroke(255, 255, 0);
        p.fill(255, 255, 0);
        for (int i = 1; i < 10000; i = i + 100) {
            p.rect(i + roadX, 200, 50, 10);
            p.rect(i + roadX, 600, 50, 10);
        }
    }

    public String getmState() {
        return mState;
    }
    public void setmState() {
        if( mState == "wait") {
            mState = "go";
        }
        else if (mState == "go") {
            mState = "wait";
        }
    }
}
