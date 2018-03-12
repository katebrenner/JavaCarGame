import processing.core.PApplet;

public class Start {
    PApplet p;
    int roadX = 50;
    Start(PApplet p){
        this.p = p;
    }
    public void display(){
        p.background(124,252,0);
        p.fill(100,100,100);
        p.rect(0, 200, 1024, 400);
        p.fill(255, 255, 0);
        for (int i = 1; i < 1000000; i = i + 100) {
            p.rect(i + roadX, 400, 50, 10);
        }
        p.fill(0);
        p.text("Racing Through The Blizzard", 300, 120);
        p.text("Hurry! It just Started Snowing!",310, 300);
        p.text( "Press Down on Key A for to get the yellow car home and Key L to the blue car home!", 200, 400, 650, 500);
        p.text("click here to start", 375, 600);
        roadX = roadX - 1;
    }

}
