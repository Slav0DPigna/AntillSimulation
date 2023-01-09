package AntillProcessing;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main extends PApplet {
    protected Ant[] ants=new Ant[100];
    protected ArrayList<Food> foods=new ArrayList<>();
    protected int num;
    protected boolean visibile, aggiungi;



    @Override
    public void setup() {
        for(int i=0;i<ants.length;i++)
            ants[i]=new Ant();
        num=0;
        visibile=false;
        aggiungi=false;
        frameRate(60);
    }//setup

    private void disegnaTraccia(Ant ant){
        for(int i=0;i<ant.positions.size()-1;i++)
            line(ant.positions.get(i).getX(),ant.positions.get(i).getY(),ant.positions.get(i+1).getX(),ant.positions.get(i+1).getY());
    }

    public void settings(){
        size(1280,720);

    }

    @Override
    public void draw() {
        background(255,255,255);
        fill(0,255,255);
        circle(640,360,50);
        if(key=='n') {
            aggiungi = true;
            key=' ';
        }
        if (aggiungi) {
            int randomX=new Random().nextInt(0,1280);
            int randomY=new Random().nextInt(0,720);
            while(randomX>615 && randomX<665)
                randomX=new Random().nextInt(0,1280);
            while(randomY>335 && randomY<385)
                randomY=new Random().nextInt(0,720);
            foods.add(new Food(new Position(randomX, randomY), 50));
            for(int i=0;i<foods.size();i++)
                println(foods.get(i));
            aggiungi=false;
            println("--------------");
        }
        if(key=='t') {
            visibile = true;
            key=' ';
        }
        if(key=='h')
            visibile=false;
        if(visibile)
            for(int i=0;i<ants.length;i++)
                if(!ants[i].isCarica())
                    disegnaTraccia(ants[i]);
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
* TODO
*  aggiustare il fatto che aggiunge due volte il cibo invece di una, rendere il movimento
*  delle formiche più fluido implementare le traccie di feromoni
* */
    public static void main(String[] args) {
        main("AntillProcessing.Main");
    }//main
}//Main
