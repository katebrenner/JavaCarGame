import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

import static javax.swing.JOptionPane.*;

public class MainApp extends PApplet {
    private Car car1;
    private Car car2;
    private Game game;
    private Snow snow;
//    private int[] nums;
    PImage webImg1;
    PImage webImg2;
    PFont font;

    public static void main(String[] args){
        PApplet.main("MainApp", args);
    }

    //defines size of screen
    public void settings(){
        size(1024, 800);
    }
    public void setup() {
        String[] fontList = PFont.list();
        printArray(fontList);
        font = createFont("Futura", 32);
        textFont(font);
        String url1 = "http://www.clker.com/cliparts/r/Z/D/N/E/w/red-car-top-view-hi.png";
        String url2 = "http://www.clker.com/cliparts/f/r/5/5/H/c/red-car-top-view-hi.png";
        webImg1 = loadImage(url1, "png");
        webImg2 = loadImage(url2, "png");
        webImg1.resize(100, 50);
        webImg2.resize(100,50);
        car1 = new Car(this, webImg1, "Car1", 250, 100, 'a', 0 );
        car2 = new Car(this, webImg2, "Car2",450, 100, 'w', 0 );
        game = new Game(this, "go");
        snow = new Snow(this);
        game.render();
//        println(width);
//        println(game.getmState());
//        nums = new int[100];
//        nums[4] = 100;
//        print(nums);
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
            fill(0);
            noStroke();
            String L = "Leader Board:";
            float tw;
            tw = textWidth(L);
            text(L, 700, 60);
            rect(700, 60, tw, 5);
            text("Player 1: ", 700, 120);
            text(car1.getScore(), 900, 120);
            text("Player 2: ", 700, 180);
            text(car2.getScore(), 900, 180);
            snow.display();
        }

    }
    public void keyReleased() {
        if (keyCode == 65) {
            car1.keyPressed();
        } else if (keyCode == 76) {
            car2.keyPressed();
        }
        if (keyCode == 83 || keyCode == 75 ) {
//            game.wrongInput();
            showMessageDialog(null, "Please use A for player 1 and L for player 2",
                    "Alert", ERROR_MESSAGE);
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
//  if y coordinate of one of the cars reaches the width of the screen, there is a winner - done
// get fonts to work -done
// gain user input for the cars racing, so that their name can be displayed for the cars
// switch out the cars so that they are not squares - done
//look into 3d background
// when there is a winner, name appears and adjust winner count
// how do you make the screen full screen?
//make the a state for play state and not play state
// when in not play state  then noloop, when in play state, can loop
//can redefine variables in if statement