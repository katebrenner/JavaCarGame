import processing.core.PApplet;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Game {
    PApplet p;
    int roadX = 50;
    Game(PApplet p){
        this.p = p;
    }
    public void render() {
        //rendering
        p.background(124,252,0);
//        p.stroke(100, 100, 100);
        p.fill(100,100,100);
        p.rect(0, 200, 1024, 400);
        p.fill(255, 255, 0);
        for (int i = 1; i < 1000000; i = i + 100) {
            p.rect(i + roadX, 400, 50, 10);
        }
        //logic
        roadX = roadX - 1;
    }
    public void wrongInput() {
        showMessageDialog(null, "Please use A for player 1 and L for player 2",
                "Alert", ERROR_MESSAGE);
    }
}
