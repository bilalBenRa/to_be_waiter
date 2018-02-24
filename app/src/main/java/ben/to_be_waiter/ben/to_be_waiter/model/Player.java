package ben.to_be_waiter.ben.to_be_waiter.model;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by bilel on 19/07/2017.
 */

public class Player  {

    private STATE state;
    private double x;
    private double y;




    public void up(){
      /* switch (directionJump){
           case UP:
               upGo();
               break;
       }*/
    }


    private void upGo(){

          /*  saut += 2.1;
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
            }*/
    }

    public void stay(double x,double y){
      /*  this.saut=-40;
        this.down=false;
        this.setY(y);
        this.setX(x);*/
    }




    public Player(double x , double y){
        //image= new Image(c,x,y,w,h,ressource);
        state = STATE.STAY;
        this.x=x;
        this.y=y;

    }

    public void draw(Canvas canvas,double x,double y){
      /*  switch(state){
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
        super.draw(canvas);*/
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




}

