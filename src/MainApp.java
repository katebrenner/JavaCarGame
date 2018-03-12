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
        car1 = new Car(this, webImg1, "Car1", 250, 100, 'a');
        car2 = new Car(this, webImg2, "Car2",450, 100, 'w');
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
            for (int i = 0; i < 1000; i ++) {
                snow[i].display();
                snow[i].descend();
                snow[i].restart();
            }
        }
        else {
            noStroke();
            game.render();
            car1.render();
            car2.render();
            fill(0);
            String L = "Leaderboard:";
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
        if(mouseX > 350  && mouseX < 450 && mouseY > 550 && mouseY < 650) {
            start = true;
        }

    }
}