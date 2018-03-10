import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;

public class MainApp extends PApplet {
    private Car car1;
    private Car car2;
//    private PFont zigBlack;
    private Game game;
    public static void main(String[] args){
        PApplet.main("MainApp", args);
    }

    //defines size of screen
    public void settings(){
        size(1024, 800);
    }
    public void setup() {
        car1 = new Car(this, "Car1", 255, 128, 150, 100, 'a', 0 );
        car2 = new Car(this, "Car2", 255, 128, 550, 100, 'w', 0 );
        game = new Game(this, "go");
        game.render();
    }

    //this happens over and over again
    public void draw() {
        if(game.getmState() == "wait") {
            background(255);
            text ("press mouse",500,200);
            noLoop();
        }
        else {
            game.render();
            car1.render();
            car2.render();
            fill(0, 140); // Fill black with low opacity
            String L = "Leader Board:";
            float tw;
            tw = textWidth(L);
            text(L, 700, 60);
            rect(700, 60, tw, 5);
            text("Player 1: ", 700, 120);
            text(car1.getScore(), 900, 120);
            text("Player 2: ", 700, 180);
            text(car2.getScore(), 900, 180);

        }

    }

    //specific to processing program
    public void keyPressed() {
        if (keyCode == 65) {
            car1.keyPressed();
        } else if (keyCode == 76) {
            car2.keyPressed();
        }
        if (car1.getmX() == 1000) {
//            car1.setmScore();
            car1.setmX();
            car2.setmX();
//            noLoop();
        } else if (car2.getmX() == 1000) {
//            car2.setmScore();
            car1.setmX();
            car2.setmX();
//            noLoop();
        }

    }

}


//need to make a car class that gets 2 instances - done
// if keydown a is pressed, move car a, if keydown L is pressed, move car b - done
// the keydown will move the y-coordinate of the car - done
//if y coordinate of one of the cars reaches the width of the screen, there is a winner - done
// get fonts to work
// gain user input for the cars racing, so that their name can be displayed for the cars
// switch out the cars so that they are not squares
//look into 3d background
// when there is a winner, name appears and adjust winner count
// how do you make the screen full screen?

//make the a state for play state and not play state
// when in not play state  then noloop, when in play state, can loop