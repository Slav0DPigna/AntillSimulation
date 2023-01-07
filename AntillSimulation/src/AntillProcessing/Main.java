package AntillProcessing;

import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    protected Ant[] ants=new Ant[1];
    protected ArrayList<Food> foods=new ArrayList<>();


    @Override
    public void setup() {
        for(int i=0;i<1;i++)
            ants[i]=new Ant();
        frameRate(120);
    }//setup

    public void settings(){
        size(1280,720);

    }

    @Override
    public void draw() {
        background(255,255,255);
        if (mousePressed && key == 'n') {
            foods.add(new Food(new Position(mouseX, mouseY), 50));
            key = ' ';
            for (int i = 0; i < foods.size(); i++)
                println(foods.get(i));
        }
        for (int i = 0; i < foods.size(); i++) {
            fill(255, 255, 0);
            circle(foods.get(i).getPos().getX(), foods.get(i).getPos().getY(), foods.get(i).getExtension());
        }
        for (int i = 0; i < ants.length; i++) {
            fill(255, 0, 0);
            circle(ants[i].getX(), ants[i].getY(), 10);
        }
        if(key=='r')
            for(int i=0;i<ants.length;i++)
                ants[i].goBack();
        else
            for (int i = 0; i < ants.length; i++)
                ants[i].move();
        redraw();
    }

    public static void main(String[] args) {
        main("AntillProcessing.Main");
    }//main
}//Main
