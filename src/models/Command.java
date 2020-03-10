package models;

public class Command {
    private Point a;
    private Point b;
    private boolean isArc = false;
    private boolean isClockWise = false;

    public Command(Point a, Point b){
        this.a = a;
        this.b = b;
        isArc = false;
    }

    public Command(Point a, Point b, boolean arc, boolean isClockWise){
        this.a = a;
        this.b = b;
        isArc = arc;
        this.isClockWise = isClockWise;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public boolean isArc() {
        return isArc;
    }

    public int getLength(){
        if(a.getY() == b.getY()){
            return  Math.abs(b.getX() - a.getX());
        }
        else{
            return Math.abs(b.getY() - a.getY());
        }
    }

    public boolean isHorizontal(){
        if(a.getY() == b.getY()){
            return true;
        }
        else return false;
    }

    public boolean isReverse(){
        if(a.getX() > b.getX() || a.getY() > b.getY()){
            return true;
        }
        return false;
    }

    public boolean isClockWise() {
        return isClockWise;
    }

    @Override
    public String toString() {
        return "Command{" +
                "a=" + a.getX() + " " + a.getY() +
                ", b=" + b.getX() + " " + b.getY() +
                ", isArc=" + isArc +
                ", isClockWise=" + isClockWise +
                '}';
    }
}
