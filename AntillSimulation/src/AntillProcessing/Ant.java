package AntillProcessing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Ant {

    private Position pos;
    private LinkedList<Position> positions=new LinkedList<>();
    public Ant(int x,int y){
        pos=new Position(x,y);
        positions.add(pos);
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

    public void goBack() {
        if(positions.size()>0) {
            this.pos = new Position(positions.pop());
            System.out.println(this);
        }
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
