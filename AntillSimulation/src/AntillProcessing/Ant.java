package AntillProcessing;

import java.util.*;

public class Ant {

    private Position pos;
    public LinkedList<Position> positions=new LinkedList<>();
    private boolean carica;
    public Ant(int x,int y){
        pos=new Position(x,y);
        positions.add(pos);
        carica=false;
    }//Builder

    public Ant(){
        pos=new Position(1280/2,360);
        positions.add(pos);
    }

    public int getX() {
        return pos.getX();
    }//getX

    public int getY() {
        return pos.getY();
    }//getY

    public void move(int num){
        int x = pos.getX();
        int y = pos.getY();
        if(new Random().nextBoolean()) {
            int randomX = new Random().nextInt(-1, 2);
            int randomY = new Random().nextInt(-1, 2);
            while (x + randomX >= 1280)
                randomX = new Random().nextInt(-4, 0);
            while (x + randomX <= 0)
                randomX = new Random().nextInt(0, 4);
            while (y + randomY >= 720)
                randomY = new Random().nextInt(-4, 0);
            while (y + randomY <= 0)
                randomY = new Random().nextInt(0, 4);
            Position park = new Position(x + randomX, y + randomY);
            this.pos = new Position(park);
            if (num % 5 == 0)
                positions.push(pos);
        }else{
            int randomX=0;
            int randomY=0;
            boolean bRandomX=new Random().nextBoolean();
            boolean bRandomY=new Random().nextBoolean();
            if(bRandomX && pos.x+1<1280 )
                randomX = 1;
            if(!bRandomX && pos.x-1>0)
                randomX=-1;
            if(bRandomY && pos.y+1<720)
                randomY=1;
            if(!bRandomY && pos.y-1>0)
                randomY=-1;
            this.pos=new Position(pos.x+randomX,pos.y+randomY);
        }
    }//move

    public void goBack(int num) {
        if(positions.size()>0) {
            this.pos = new Position(positions.pop());
            System.out.println(this);
            if ((Math.sqrt(Math.pow(((1280)/2-this.pos.x),2)+(Math.pow(360-this.pos.y,2)))<=25))
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
        String r="La formica si trova ne punto x = "+getX()+" , "+" y = "+getY();
        return r;
    }//toString
}//Ant
