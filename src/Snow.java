import processing.core.PApplet;

public class Snow {
    PApplet p;
    float Num;
    float Num2;

    Snow(PApplet p) {
        this.p = p;
        Num = p.random(0, p.width);
        Num2 = 0;
    }

    public void display() {
        p.stroke(0);
        p.fill(127);
        p.ellipse(Num, Num2, 10, 10);

    }
}
