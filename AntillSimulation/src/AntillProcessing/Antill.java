package AntillProcessing;

import java.util.ArrayList;
import java.util.Random;

public class Antill {
    /*
    questa classe deve contenere il cibo e le formiche che devono interagire tra di loro
     */

    private Ant[] ants;
    private ArrayList<Food> foods;
    private Random r=new Random();
    public Antill(int antsNum){
        ants=new Ant[antsNum];
        foods=new ArrayList<>();
        for(int i=0;i<antsNum;i++)
            ants[i]=new Ant(foods);
    }//Builder

    public void addFood(){
        int randomX=r.nextInt(0,1280);
        int randomY=r.nextInt(0,720);
        while (randomX>615 && randomX<665)
            randomX=r.nextInt(0,1280);
        while (randomY>335 && randomY<385)
            randomY=r.nextInt(0,720);
        Position pos=new Position(randomX,randomY);
        foods.add(new Food(pos,50));
    }//addFood

    public void removeFood(int i){
        foods.remove(i);
    }

    public void moveAnts(){
        for(int i=0;i<ants.length;i++) {
            if (ants[i].isCarica())
                ants[i].goBack();
            else
                ants[i].move();
        }
    }//moveAnts

    public Ant[] getAnts(){
        return ants;
    }//getAnts

    public ArrayList<Food> getFoods(){
        return foods;
    }
}//Antill
