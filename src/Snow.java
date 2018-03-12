import processing.core.PApplet;

public class Snow {
    PApplet p;
    float Num;
    float Num2;
    float d;

    Snow(PApplet p, float diameter) {
        this.p = p;
        Num = p.random(0, p.width);
        Num2 = p.random(-20, 900);
        d = diameter;
    }

    public void descend() {
        Num2 = Num2 + 2;
        Num = Num + p.random(-1,1);
    }

    public void display() {
        p.fill(255,140);
        p.noStroke();
        p.ellipse(Num, Num2, d, d);
    }
    public void restart() {
        if (Num2 > 900) {
            Num2 = 0;
        }
    }
    public float getNum2() {
        return Num2;

    }
}
