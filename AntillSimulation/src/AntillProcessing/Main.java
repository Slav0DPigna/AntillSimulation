package AntillProcessing;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main extends PApplet {

    protected Antill antill;
    protected int num;
    protected boolean visibile, aggiungi;



    @Override
    public void setup() {
        antill=new Antill(100);
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
        smooth();
    }

    @Override
    public void draw() {
        background(255,255,255);
        fill(150,75,0);
        circle(640,360,50);
        if(antill.getFoods().size()>0)
            for(int i=0;i<antill.getFoods().size();i++) {
                if(antill.getFoods().get(i).getExtension()<=0)
                    antill.removeFood(i);
                else {
                    fill(0, 255, 0);
                    int extension = antill.getFoods().get(i).getExtension();
                    circle(antill.getFoods().get(i).getPos().x, antill.getFoods().get(i).getPos().y, extension);
                }
            }
        if(key=='a') {
            antill.addFood();
            key=' ';
        }
        if(key=='t')
            for(int i=0;i<antill.getAnts().length;i++)
                disegnaTraccia(antill.getAnts()[i]);
        for(int i=0;i<antill.getAnts().length;i++) {
            if(antill.getAnts()[i].isCarica()){
                fill(0,0,255);
                circle(antill.getAnts()[i].getX(),antill.getAnts()[i].getY(),10);
            }else {
                fill(255,0,0);
                circle(antill.getAnts()[i].getX(),antill.getAnts()[i].getY(),10);
            }
        }
        antill.moveAnts();
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
