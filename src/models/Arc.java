package models;

public class Arc {
    private Point a;
    private Point b;
    private int x;
    private int y;
    private int length;
    private int width;
    private int startAngle;
    private int arcAngle;
    private boolean isClockWise;

    public Arc(Point a, Point b, boolean isClockWise){
        this.a = a;
        this.b = b;
        this.isClockWise = isClockWise;
        computeParameters(a, b);
    }

    private void computeParameters(Point a, Point b){
        if(a.getY() == b.getY()){
            length = Math.abs(b.getX() - a.getX());
            width = length;
            if(a.getX() > b.getX()){
                  startAngle = 0;
                  if(isClockWise){
                      arcAngle = -180;
                  }
                  else {
                      arcAngle = 180;
                  }
                  x = b.getX();
                  y = b.getY() - length/2;
                  return;
            }
            else {
                startAngle = -180;
                if(isClockWise){
                    arcAngle = -180;
                }
                else {
                    arcAngle = 180;
                }
                x = a.getX();
                y = a.getY() - length / 2;
                return;
            }
        }

        if(a.getX() == b.getX()){
            length = Math.abs(b.getY() - a.getY());
            width = length;
            if(a.getY() > b.getY()){
                  startAngle = -90;
                  if(isClockWise){
                      arcAngle = -180;
                  }
                  else{
                      arcAngle = 180;
                  }

                  x = b.getX() - length/2;
                  y = b.getY();
                  return;
            }
            else {
                startAngle = 90;
                if(isClockWise){
                    arcAngle = -180;
                }
                else{
                    arcAngle = +180;
                }
                x = a.getX() - length / 2;
                y = a.getY();
                return;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public int getArcAngle() {
        return arcAngle;
    }

    public boolean isClockWise() {
        return isClockWise;
    }
}
