/**
 * Created by bilel on 13/07/2017.
 */
package ben.to_be_waiter.ben.to_be_waiter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import ben.to_be_waiter.ben.to_be_waiter.model.GameModel;
import ben.to_be_waiter.ben.to_be_waiter.model.Player;


// SurfaceView est une surface de dessin.
// référence : http://developer.android.com/reference/android/view/SurfaceView.html
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    // déclaration de l'objet définissant la boucle principale de déplacement et de rendu
    private GameLoopThread gameLoopThread;

    private int h,w;
    private GameModel gameModel;




    // création de la surface de dessin
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        gameLoopThread = new GameLoopThread(this);

        // création d'un objet "balle", dont on définira la largeur/hauteur
        // selon la largeur ou la hauteur de l'écran

        WindowManager w = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics d =new DisplayMetrics();
        w.getDefaultDisplay().getMetrics(d);
        h=d.heightPixels;
        this.w = d.widthPixels;


      //  player= new Player(this.getContext(),plateformList.get(0).getX(),plateformList.get(0).getY(),this.w/7,h/11,R.mipmap.p1_front);


    }

    // Fonction qui "dessine" un écran de jeu
    public void doDraw(Canvas canvas) {
        if(canvas==null) {return;}

        // on efface l'écran, en blanc
        canvas.drawColor(Color.WHITE);
        //player.onDraw(canvas);



      //  player.draw(canvas,plateformStay.getX(),plateformStay.getY() - player.getDrawH());





    }

    // Fonction appelée par la boucle principale (gameLoopThread)
    // On gère ici le déplacement des objets
    public void update() {
       // balle.moveWithCollisionDetection();
    }

    // Fonction obligatoire de l'objet SurfaceView
    // Fonction appelée immédiatement après la création de l'objet SurfaceView
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        // création du processus GameLoopThread si cela n'est pas fait
        if(gameLoopThread.getState()==Thread.State.TERMINATED) {
            gameLoopThread=new GameLoopThread(this);
        }
        gameLoopThread.setRunning(true);
        gameLoopThread.start();
    }

    // Fonction obligatoire de l'objet SurfaceView
    // Fonction appelée juste avant que l'objet ne soit détruit.
    // on tente ici de stopper le processus de gameLoopThread
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        gameLoopThread.setRunning(false);
        while (retry) {
            try {
                gameLoopThread.join();
                retry = false;
            }
            catch (InterruptedException e) {}
        }
    }

    // Gère les touchés sur l'écran
    @Override
    public boolean onTouchEvent(MotionEvent event) {
      /*  double currentX = event.getX();
        if(currentX>=player.getX()){
            player.setDirection(false);
        }else {
            player.setDirection(true);
        }
        double currentY = event.getY();
        currentX = currentX-player.getX();
        currentY=currentY-player.getY();
        double angle = Math.atan2(currentX,currentY);


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(player.getState()==STATE.STAY || player.getState()==STATE.DOWN ) {
                    player.calculeDirectionUp(w / 3);
                    player.setAngle(angle);
                    player.setState(STATE.UP);

                }
                break;
        }*/


        return true;  // On retourne "true" pour indiquer qu'on a géré l'évènement
    }

    // Fonction obligatoire de l'objet SurfaceView
    // Fonction appelée à la CREATION et MODIFICATION et ONRESUME de l'écran
    // nous obtenons ici la largeur/hauteur de l'écran en pixels
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int w, int h) {
       /* balle.resize(w,h); // on définit la taille de la balle selon la taille de l'écran
       bar2.resize(w,h);*/
        this.h=h;
    }

    public void collision(){
       /* double xPlayer= player.getX();
        double yPlayer=player.getY();
        double yPlateform;
        for(Plateform p:plateformList){
            yPlateform= (p.getY()-player.getDrawH());
            double a = player.getY()+player.getDrawH();

           // System.out.println("player x "+player.getX()+" plateform x "+plateformStay.getX() +" plat + w " + (plateformStay.getX()+plateformStay.getDrawW()));
            if(
                    (player.getX() >=  p.getX()) &&( player.getX() <= ( p.getX() + p.getDrawW())))

            {

                System.out.println("a "+a+" p +15  "+(p.getY()+15)+" p -15 y "+(p.getY()-15));
                player.setState(STATE.DOWN);
                this.plateformStay=p;
                break;

            }
        }
      //  System.out.println("player x "+player.getX()+" plateform x "+plateformStay.getX()+" x + w plateform "+(plateformStay.getX()+plateformStay.getDrawW()));
*/


    }
} // class GameView