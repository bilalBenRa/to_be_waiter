package ben.to_be_waiter.ben.to_be_waiter.model;

/**
 * Created by BBABE69 on 3/03/2018.
 */

public  abstract class ElementGame {
    private Position position;
    private Position positionBeta;
    private STATE state;



    public ElementGame(double x , double y,double xBeta,double yBeta){
        this.position= new Position(x,y);
        this.positionBeta= new Position(xBeta,yBeta);
    }
    public ElementGame(double x , double y){
        this.position= new Position(x,y);
    }



    public double getX(){
        return this.position.getX();
    }

    public double getY(){
        return this.position.getY();
    }

    public double getXBeta(){
        return this.positionBeta.getX();
    }

    public double getYBeta(){
        return this.positionBeta.getY();
    }

    public void setX(double x){
        this.position.setX(x);
    }

    public void setXBeta(double x){
        this.positionBeta.setX(x);
    }


    public  void setY(double y){
        this.position.setY(y);
    }

    public abstract void move();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }
}
