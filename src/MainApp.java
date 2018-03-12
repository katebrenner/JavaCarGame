import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;

import static javax.swing.JOptionPane.*;

public class MainApp extends PApplet {
    private Car car1;
    private Car car2;
    private Game game;
    private Snow[] snow;
    private boolean start;
    private Start splash;
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
        game = new Game(this);
        snow = new Snow[1000];
        for (int i = 0; i < 1000; i ++) {
            snow[i] = new Snow(this, 10);
        }
        boolean start = false;
        splash = new Start(this);
    }
    public void draw() {
        if(start == false) {
            splash.display();
        }
        else {
            noStroke();
            game.render();
            car1.render();
            car2.render();
            fill(0);
            String L = "Leader Board:";
            float tw;
            tw = textWidth(L);
            text(L, 700, 60);
            rect(700, 60, tw, 5);
            text("Player 1: ", 700, 120);
            text(car1.getScore(), 900, 120);
            text("Player 2: ", 700, 180);
            text(car2.getScore(), 900, 180);
            for (int i = 0; i < 1000; i ++) {
                snow[i].display();
                snow[i].descend();
                snow[i].restart();
            }
        }
    }
    public void keyReleased() {
        if (keyCode == 65) {
            car1.keyPressed();
        } else if (keyCode == 76) {
            car2.keyPressed();
        }
        if (keyCode == 83 || keyCode == 75 ) {
            game.wrongInput();
        }
        if (car1.getmX() == 1000) {
            car1.setmX();
            car2.setmX();
        } else if (car2.getmX() == 1000) {
            car1.setmX();
            car2.setmX();
        }

    }
    public void mouseClicked() {
        if(mouseX > 300  && mouseX < 500 && mouseY > 110 && mouseY < 130) {
            start = true;
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
// when there is a winner, name appears and adjust winner count
//m ake the a state for play state and not play state
// when in not play state  then noloop, when in play state, can loop
//can redefine variables in if statement