package ben.to_be_waiter;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by bilel on 19/07/2017.
 */

public class Player extends Draw {
    private int frame;
    private double destY;
    private double destX;
    private double size;
    private double y0;
    private int frameStart;
    double saut = -30;
    private boolean down=false;
    private double angle;
    private boolean direction=false;

    private STATE state;



    public double getDestY() {
        return destY;
    }

    public void up(){
      /* switch (directionJump){
           case UP:
               upGo();
               break;
       }*/
    }


    private void upGo(){

            saut += 2.1;
            y += saut;
            if(!direction) {
                x -= ((angle - 90) / 45) * 2.1;
            }else{
                x += ((angle - 90) / 45) * 2.1;
            }

            if(saut>0){
                this.down=true;
            }else{
                this.down=false;
            }
    }

    public void stay(double x,double y){
        this.saut=-40;
        this.down=false;
        this.setY(y);
        this.setX(x);
    }

    public void setDestY(double destY) {
        this.destY = destY;
    }

    public double getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }



    public Player(final Context c, double x , double y, int w , int h, int ressource){
        super(c,x,y,w,h,ressource);
        frame=0;
        state = STATE.STAY;

    }

    public void draw(Canvas canvas,double x,double y){
        switch(state){
            case STAY:
                stay(x,y);
                break;
            case UP:
                up();
                break;
            case DOWN:
                stay(this.x,this.y);
                break;
            default:
                break;
        }

       // super.setX(this.x);
        //super.setY(this.y);
        frame++;
        super.draw(canvas);
    }

    public boolean isDown() {
        return down;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
    }




    public void calculeDirectionUp(int div) {
       /* if(destX>=x-10&&destX<=x+super.getDrawW()+10){
            this.directionJump=DirectionJump.UP;
            size=0;
        }else if(destX<=this.x-10){
            directionJump=DirectionJump.UP;
            if((x-destX)< div){
                size=(x-destX)/40;
            }else if ((x-destX)> div && (x-destX)< (div*2)){
                size=(x-destX)/60;
            }else {
                size=(x-destX)/80;
            }

        }else if(destX>=x+super.getDrawW()+10){
            directionJump=DirectionJump.UP;
            if((destX-x)< div){
                size=(destX-x)/40;
            }else if ((destX-x)> div && (destX-x)< (div*2)){
                size=(destX-x)/60;
            }else {
                size=(destX-x)/80;
            }
        }*/

    }
    public void calculeDirectionDown() {
     /*  switch(directionJump){
           case UP:
               directionJump=DirectionJump.DOWN;
               break;
           case UPLEFT:
               directionJump=DirectionJump.DOWNLEFT;
               break;
           case UPRIGHT:
               directionJump=DirectionJump.DOWNRIGHT;
               break;
       }*/

    }

    @Override
    public void setX(double x) {
        super.setX(x);
    }

    @Override
    public void setY(double y) {
        super.setY(y);
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public int getDrawW() {
        return super.getDrawW();
    }

    @Override
    public void setDrawW(int drawW) {
        super.setDrawW(drawW);
    }

    @Override
    public int getDrawH() {
        return super.getDrawH();
    }

    @Override
    public void setDrawH(int drawH) {
        super.setDrawH(drawH);
    }


}

