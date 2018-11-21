import processing.core.PApplet;

public class Snow {
    PApplet p;
    float x;
    float y;
    float d;
    Snow(PApplet p, float diameter) {
        this.p = p;
        x = p.random(0, p.width);
        y = p.random(-20, 900);
        d = diameter;
    }
    public void descend() {
        y = y + 2;
        x = x + p.random(-1,1);
        if (y > 900) {
            y = 0;
        }
    }
    public void display() {
        p.fill(255,140);
        p.noStroke();
        p.ellipse(x, y, d, d);
    }
    public float getNum2() {
        return y;
    }
}
