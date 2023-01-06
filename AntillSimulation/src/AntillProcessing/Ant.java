package AntillProcessing;

import java.util.LinkedList;
import java.util.Random;

public class Ant {

    private Position pos;
    private LinkedList<Position> positions;

    public Ant(int x,int y){
        pos=new Position(x,y);
        positions=new LinkedList<>();
        positions.add(pos);
    }//Builder

    public Ant(){
        pos=new Position(1280/2,360);
        positions=new LinkedList<>();
        positions.add(pos);
    }

    public int getX() {
        return pos.getX();
    }//getX

    public int getY() {
        return pos.getY();
    }//getY

    public void move(){
        int x=pos.getX();
        int y = pos.getY();
        int randomX=new Random().nextInt(-5,6);
        int randomY=new Random().nextInt(-5,6);
        while(x+randomX>=1280)
            randomX=new Random().nextInt(-11,0);
        while (x+randomX<=0)
            randomX=new Random().nextInt(0,11);
        while (y+randomY>=720)
            randomY=new Random().nextInt(-11,0);
        while (y+randomY<=0)
            randomY=new Random().nextInt(0,11);
        this.pos=new Position(x+randomX,y+randomY);
        positions.add(pos);
    }//move

    //TODO
    public void ritorna(){
        System.out.println(122);
    }

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
