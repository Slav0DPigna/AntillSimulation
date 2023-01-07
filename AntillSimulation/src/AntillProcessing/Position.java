package AntillProcessing;

public class Position {

    int x,y;

    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }//Builder

    public Position(Position p){
        this.x=p.x;
        this.y=p.y;
    }//copy builde

    public int getX() {
        return x;
    }//getX

    public int getY() {
        return y;
    }//getY

    public boolean equals(Object o){
        if(o==this)
            return true;
        if(!(o instanceof Position))
            return false;
        Position p=(Position) o;
        return this.x== p.x && this.y==p.y;
    }//equals

    public String toString(){
        return "x = "+x+" y = "+y;
    }
}//Position
