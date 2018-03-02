package ben.to_be_waiter.ben.to_be_waiter.model;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by bilel on 19/07/2017.
 */

public class Player  {

    private Position position;


    public Player(double x , double y){
        this.position= new Position(x,y);
    }

    public double getX(){
        return this.position.getX();
    }

    public double getY(){
        return this.position.getY();
    }

    public void setX(double x){
        this.position.setX(x);
    }

    public void setY(double y){
        this.position.setX(y);
    }
}

