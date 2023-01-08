package AntillProcessing;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Main extends PApplet {
    protected Ant[] ants=new Ant[50];
    protected ArrayList<Food> foods=new ArrayList<>();
    int num;


    @Override
    public void setup() {
        for(int i=0;i<50;i++)
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
            int randomX=new Random().nextInt(0,1280);
            int randomY=new Random().nextInt(0,720);
            foods.add(new Food(new Position(randomX, randomY), 50));
            for(int i=0;i<foods.size();i++)
                println(foods.get(i));
            key = ' ';
            println("--------------");
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
            if(ants[i].isCarica())
                ants[i].goBack(num);
            else
                ants[i].move(num);
        }
        for(int i=0;i<ants.length;i++) {
            int indexFood=ants[i].foodFound(foods);
            if (indexFood!=-1 && !ants[i].isCarica()) {
                foods.get(indexFood).decr();
                ants[i].setCarica(true);
                ants[i].goBack(num);
            }
        }
        num++;
        if(num==5)
            num=0;
        redraw();
    }
/*
* TODO fare la gestione tra la formica il ritorno alla base e il decremento del cibo e aggiustare il fatto che aggiunge
*  due volte il cibo invece di una
* */
    public static void main(String[] args) {
        main("AntillProcessing.Main");
    }//main
}//Main
