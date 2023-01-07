package AntillProcessing;

import java.util.*;

public class Ant {

    private Position pos;
    private LinkedList<Position> positions=new LinkedList<>();
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
        if(num%5==0) {
            int x = pos.getX();
            int y = pos.getY();
            int randomX = new Random().nextInt(-5, 7);
            int randomY = new Random().nextInt(-5, 7);
            Position park = new Position(x + randomX, y + randomY);
            while (x + randomX >= 1280)
                randomX = new Random().nextInt(-12, 0);
            while (x + randomX <= 0)
                randomX = new Random().nextInt(0, 12);
            while (y + randomY >= 720)
                randomY = new Random().nextInt(-12, 0);
            while (y + randomY <= 0)
                randomY = new Random().nextInt(0, 12);
            park = new Position(x + randomX, y + randomY);
            this.pos = new Position(park);
            positions.push(pos);
        }
    }//move

    public boolean goBack(int num) {
        if(positions.size()>0 && num%5==0) {
            this.pos = new Position(positions.pop());
            System.out.println(this);
        }
        return this.pos.equals(new Position(1280/2,360));
    }//goBack

    public void setCarica(boolean value){
        this.carica=value;
    }

    public int foodFound(ArrayList<Food> foods){
        int r=-1;
        for(int i=0;i<foods.size();i++){
            double distanzaPuntoPunto=((Math.sqrt(Math.pow((foods.get(i).getPos().getX()-this.pos.x),2)+(Math.pow(foods.get(i).getPos().getY()-this.pos.y,2))))/2);
            if(foods.get(i).getExtension()>=distanzaPuntoPunto) {
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
