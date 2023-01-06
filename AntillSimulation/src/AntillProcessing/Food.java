package AntillProcessing;

public class Food {
    private int extension;
    private Position pos;

    public Food(Position pos,int extension){
        this.pos=new Position(pos.x, pos.y);
        this.extension=extension;
    }

    public int getExtension() {
        return extension;
    }

    public Position getPos() {
        return pos;
    }

    public void decr(){
        extension--;
    }

    public String toString(){
        return " x= "+pos.x+" y= "+pos.y+" ex= "+extension;
    }
}
