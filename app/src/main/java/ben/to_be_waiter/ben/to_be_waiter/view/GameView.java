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
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import ben.to_be_waiter.R;
import ben.to_be_waiter.ben.to_be_waiter.model.Food;
import ben.to_be_waiter.ben.to_be_waiter.model.GameModel;
import ben.to_be_waiter.ben.to_be_waiter.model.STATE;
import ben.to_be_waiter.ben.to_be_waiter.model.TestFood;


// SurfaceView est une surface de dessin.
// référence : http://developer.android.com/reference/android/view/SurfaceView.html
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    // déclaration de l'objet définissant la boucle principale de déplacement et de rendu
    private GameLoopThread gameLoopThread;

    private GameModel toBeWaiterModel;
    private Draw playerDraw;
    private Draw plateauDraw;
    private List<Draw> foodsDraw;
    private boolean ok=false;
    private int height;
    private int width;
    private int xDelta;
    private Context context;

    // création de la surface de dessin
    public GameView(Context context) {
        super(context);
        this.context=context;
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
        this.foodsDraw=new ArrayList<>();
        this.toBeWaiterModel = new GameModel();
        this.loadGame();
    }


    private void loadGame(){
        this.loadPlayer();
        this.loadPlateau();
        this.loadFoods();
    }



    private void loadPlayer(){
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
        int heightPlayer=height/2;
        int a = (heightPlayer)+((int)nbb+(int)nbbb)-(J);

        int  yPlayerDraw=height-a;
        this.toBeWaiterModel.loadPlayer((width/2)-(width/12),yPlayerDraw);
        this.playerDraw= new Image(context, toBeWaiterModel.getPlayer().getX(), toBeWaiterModel.getPlayer().getY(),width/6,heightPlayer, R.mipmap.perso4);
    }


    private void loadPlateau() {
        int heigthPlateau = 50;
        int widthPlateau = (int) playerDraw.getDrawWidth();
        this.toBeWaiterModel.loadPlateau(toBeWaiterModel.getPlayer().getX(),toBeWaiterModel.getPlayer().getY()+10-heigthPlateau,toBeWaiterModel.getPlayer().getX()+widthPlateau,toBeWaiterModel.getPlayer().getY()+10);
        this.plateauDraw= new Image(this.context,toBeWaiterModel.getPlateau().getX(),toBeWaiterModel.getPlateau().getY(),widthPlateau,heigthPlateau,R.mipmap.plateau);
    }

    private void loadFoods() {
        int heigthFood = 60;
        int widthFood = 80;
        this.toBeWaiterModel.loadFood(toBeWaiterModel.getPlayer().getX()+165,-150);
        this.foodsDraw.add(new Image(this.context,toBeWaiterModel.getFoods().get(0).getX(),toBeWaiterModel.getFoods().get(0).getY(),widthFood,heigthFood,R.mipmap.food1));
        toBeWaiterModel.getFoods().get(0).setState(STATE.MOVE);

    }



    private void gameFrame(Canvas canvas){
        this.playerFrame(canvas);
        this.plateauFrame(canvas);
        this.foodsFrame(canvas);
    }

    private void playerFrame(Canvas canvas){
        playerDraw.setX(toBeWaiterModel.getPlayer().getX());
        playerDraw.setY(toBeWaiterModel.getPlayer().getY());
        this.playerDraw.draw(canvas);
    }

    private void plateauFrame(Canvas canvas) {

        plateauDraw.setX(toBeWaiterModel.getPlateau().getX());
        plateauDraw.setY(toBeWaiterModel.getPlateau().getY());
        this.plateauDraw.draw(canvas);

    }



    private void foodsFrame(Canvas canvas){
        for(int i =0;i <toBeWaiterModel.getFoods().size();i++){
            if(toBeWaiterModel.collisionPlateauToFoods(i)){
                toBeWaiterModel.getFoods().get(i).setState(STATE.STAY);
            }else {
                toBeWaiterModel.getFoods().get(i).setState(STATE.MOVE);
            }
            if(toBeWaiterModel.getFoods().get(i).getState()==STATE.MOVE){
                toBeWaiterModel.getFoods().get(i).move();
            }

            this.foodsDraw.get(i).setX(toBeWaiterModel.getFoods().get(i).getX());
            this.foodsDraw.get(i).setY(toBeWaiterModel.getFoods().get(i).getY());
            this.foodsDraw.get(i).draw(canvas);

        }

    }

    // Fonction qui "dessine" un écran de jeu
    public void doDraw(Canvas canvas) {
        if(canvas==null) {return;}
        // on efface l'écran, en blanc
        canvas.drawColor(Color.WHITE);
        this.gameFrame(canvas);
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
                ok = ((x >= playerDraw.getX()) && (x <= playerDraw.getX() + playerDraw.getDrawWidth()) && (y <= height ) && (y >= height - playerDraw.getDrawHeight()));
                xDelta = x - (int) playerDraw.getX(); //35-39=-4
                break;

            case MotionEvent.ACTION_MOVE:
                if (ok){
                    double val = toBeWaiterModel.getPlateau().getXBeta()-toBeWaiterModel.getPlateau().getX();
                    toBeWaiterModel.getPlayer().setX(x - xDelta);
                    toBeWaiterModel.getPlateau().setX(x - xDelta);
                    toBeWaiterModel.getPlateau().setXBeta(toBeWaiterModel.getPlateau().getX()+val);

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