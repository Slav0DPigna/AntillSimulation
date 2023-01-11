package AntillProcessing;

import java.util.*;

public class Ant {

    private Position pos;
    public LinkedList<Position> positions=new LinkedList<>();
    private ArrayList<Food> foodArrayList;

    private Random r=new Random();
    private int myFood;
    private boolean carica;
    public Ant(int x,int y,ArrayList<Food> foodList){
        pos=new Position(x,y);
        if(foodList.size()!=0)
            myFood=r.nextInt(0,foodList.size());
        else
            myFood=-1;
        foodArrayList=foodList;
        carica=false;
    }//Builder

    public Ant(ArrayList<Food> foodList){
        pos=new Position(640,360);
        foodArrayList=foodList;
        if(foodList.size()>0)
            myFood=new Random().nextInt(0,foodList.size());
        else
            myFood=-1;
        carica=false;
    }

    public int getX() {
        return pos.getX();
    }//getX

    public int getY() {
        return pos.getY();
    }//getY

    public void move(){
        if (this.myFood!= -1) {
            int x = pos.getX();
            int y = pos.getY();
            Random r = new Random();
            int randomY = r.nextInt(-2, 3);
            int randomX = r.nextInt(-2, 3);
            while (x + randomX >= 1280)
                randomX = r.nextInt(-2, 0);
            while (x + randomX <= 0)
                randomX = r.nextInt(0, 3);
            while (y + randomY >= 720)
                randomY = r.nextInt(-2, 0);
            while (y + randomY <= 0)
                randomY = r.nextInt(0, 3);
            this.pos = new Position(x + randomX, y + randomY);
            if (((Math.sqrt(Math.pow((640 - this.pos.x), 2) + (Math.pow(360 - this.pos.y, 2))) >= 25)))
                positions.push(pos);
            for(int i=0;i<foodArrayList.size();i++)
                if(!this.carica && (Math.sqrt(Math.pow(foodArrayList.get(i).getPos().x-this.pos.x,2)+(Math.pow(foodArrayList.get(i).getPos().y-this.pos.y,2)))<=25)) {
                    foodArrayList.get(i).decr();
                    this.carica=true;
            }
        }else
            if(foodArrayList.size()>0)
                this.myFood=r.nextInt(0,foodArrayList.size());

    }//move

    public void goBack() {
        if(positions.size()>0 ) {
            this.pos = new Position(positions.pop());
            if ((Math.sqrt(Math.pow(((1280)/2-this.pos.x),2)+(Math.pow(360-this.pos.y,2)))<=30))
                carica = false;
        }
    }//goBack

    public void setCarica(boolean value){
        this.carica=value;
    }

    public boolean isCarica() {
        return carica;
    }

    public int foodFound(ArrayList<Food> foods){
        int r=-1;
        for(int i=0;i<foods.size();i++){
            double distanzaPuntoPunto=(Math.sqrt(Math.pow((foods.get(i).getPos().getX()-this.pos.x),2)+(Math.pow(foods.get(i).getPos().getY()-this.pos.y,2))));//raggio cibo
            if((foods.get(i).getExtension()/2)>=distanzaPuntoPunto) {
                r = i;
                return r;
            }
        }
        return r;
    }//foodFound

    public int hashCode(){
        int r=13;
        r=r*toString().hashCode()*83;
        return r;
    }//hashCode

    public String toString(){
        String r="";
        if(foodArrayList.size()>0)
            r="La formica si trova ne punto x = "+getX()+" , "+" y = "+getY()+" il mio cibo è "+foodArrayList.get(myFood).toString();
        else
            r="La formica si trova ne punto x = "+getX()+" , "+" y = "+getY()+" non ho cibo da trovare";
        return r;
    }//toString
}//Ant
