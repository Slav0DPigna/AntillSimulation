package AntillProcessing;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Main extends PApplet {
    protected Ant[] ants=new Ant[2];
    protected ArrayList<Food> foods=new ArrayList<>();
    int num;


    @Override
    public void setup() {
        for(int i=0;i<2;i++)
            ants[i]=new Ant();
        num=0;
        frameRate(120);
    }//setup

    public void settings(){
        size(1280,720);

    }

    @Override
    public void draw() {
        background(255,255,255);
        if (key=='n') {
            key = ' ';
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            foods.add(new Food(new Position(new Random().nextInt(0,1280), new Random().nextInt(0,720)), 50));
            println(foods.get(0));
        }
        for (int i = 0; i < foods.size(); i++) {
            fill(255, 255, 0);
            circle(foods.get(i).getPos().getX(), foods.get(i).getPos().getY(), foods.get(i).getExtension());
        }
        for (int i = 0; i < ants.length; i++) {
            fill(255, 0, 0);
            circle(ants[i].getX(), ants[i].getY(), 10);
        }
        for (int i = 0; i < ants.length; i++) {
            ants[i].move(num);
            int indexFoundFood=ants[i].foodFound(foods);
            if(indexFoundFood!=-1){
                foods.get(indexFoundFood).decr();
                ants[i].setCarica(!ants[i].goBack(num));
            }
        }
        num++;
        redraw();
    }
/*
* TODO fare la gestione tra la formica il ritorno alla base e il decremento del cibo
* */
    public static void main(String[] args) {
        main("AntillProcessing.Main");
    }//main
}//Main
