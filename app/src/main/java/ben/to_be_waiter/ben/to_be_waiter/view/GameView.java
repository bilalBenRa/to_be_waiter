/**
 * Created by bilel on 13/07/2017.
 */
package ben.to_be_waiter.ben.to_be_waiter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import ben.to_be_waiter.R;
import ben.to_be_waiter.ben.to_be_waiter.model.GameModel;
import ben.to_be_waiter.ben.to_be_waiter.model.Player;


// SurfaceView est une surface de dessin.
// référence : http://developer.android.com/reference/android/view/SurfaceView.html
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    // déclaration de l'objet définissant la boucle principale de déplacement et de rendu
    private GameLoopThread gameLoopThread;

    private GameModel gameModel;
    private Draw playerDraw;
    private boolean ok=false;
    private int height;
    private int width;
    private int xDelta;
    private  int yPlayerDraw;


    // création de la surface de dessin
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        gameLoopThread = new GameLoopThread(this);
        WindowManager w = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics d =new DisplayMetrics();
        w.getDefaultDisplay().getMetrics(d);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        float nbb=0;
        float nbbb=0;
        if (resourceId > 0) {
            nbb = resources.getDimensionPixelSize(resourceId);
        }

        int statusBarHeight = 0;
        resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            nbbb = getResources().getDimensionPixelSize(resourceId);

        }
        // Calculate ActionBar height
        int  J = getResources().getDimensionPixelSize(R.dimen.abc_action_bar_default_height_material);
        int a = (height/4)+((int)nbb+(int)nbbb)-(J);

        yPlayerDraw=height-a;

        this.playerDraw= new Image(context,(width/2)-(width/12),yPlayerDraw,width/6,height/4, R.mipmap.perso);
    }

    // Fonction qui "dessine" un écran de jeu
    public void doDraw(Canvas canvas) {
        if(canvas==null) {return;}
        // on efface l'écran, en blanc
        canvas.drawColor(Color.WHITE);
        this.playerDraw.draw(canvas);
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
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int x = (int) event.getRawX();//35
        final int y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                ok = ((x >= playerDraw.getX()) && (x <= playerDraw.getX() + playerDraw.getDrawW()) && (y <= height ) && (y >= height - playerDraw.getDrawH()));
                xDelta = x - (int) playerDraw.getX(); //35-39=-4
                break;

            case MotionEvent.ACTION_MOVE:
                if (ok){
                    playerDraw.setX(x - xDelta);
                }
                break;
            default:
                return false;

        }
        return true;  // On retourne "true" pour indiquer qu'on a géré l'évènement
    }

    // Fonction obligatoire de l'objet SurfaceView
    // Fonction appelée à la CREATION et MODIFICATION et ONRESUME de l'écran
    // nous obtenons ici la largeur/hauteur de l'écran en pixels
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int w, int h) {
        //
    }

    public void collision(){
        //
    }
} // class GameView