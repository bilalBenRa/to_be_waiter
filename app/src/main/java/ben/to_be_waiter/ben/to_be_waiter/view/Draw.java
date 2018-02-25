package ben.to_be_waiter.ben.to_be_waiter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

/**
 * Created by bilel on 19/07/2017.
 */

public abstract class Draw {
    protected Bitmap img; // image

    BitmapDrawable imgB;
    protected double x,y; // coordonnées x,y de
    protected int drawW, drawH; // largeur et hauteur
    protected int wEcran,hEcran; // largeur et hauteur de l'écran en pixels
    protected int ressource;

    protected  final Context mContext;
     ImageView image=null ;

    Bitmap bitmap2;
    public Draw(final Context c,double x ,double y,int w , int h,int ressource)
    {
        this.x = x; this.y = y;
        // position de départ
        this.drawW=w;this.drawH=h;
        mContext=c; // sauvegarde du contexte
        this.ressource=ressource;
        Drawable dr = c.getResources().getDrawable(this.ressource);
        img = ((BitmapDrawable) dr).getBitmap();
        imgB= new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(img, drawW, drawH, true));
       /* img= new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(bitmap, drawW, drawH, true));
        float factorH = h / (float)bitmap.getHeight();
        float factorW = w / (float)bitmap.getWidth();
        float factorToUse = (factorH > factorW) ? factorW : factorH;
        img = Bitmap.createScaledBitmap(bitmap,
                (int) (bitmap.getWidth() * factorToUse),
                (int) (bitmap.getHeight() * factorToUse),
                false);

        System.out.println("size scaled heigth "+img.getHeight());*/
    }


    protected void  changeImg(int ressource){
        this.ressource=ressource;
        Drawable dr = mContext.getResources().getDrawable(this.ressource);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
       // img= new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(bitmap, drawW, drawH, true));
    }



    // on dessine l'image, en x et y
    protected void draw(Canvas canvas)
    {

        if(img==null) {return;}

       canvas.drawBitmap(imgB.getBitmap(),(float) x,(float) y, null);

    }





    abstract  void draw();

    public int getDrawW() {
        return drawW;
    }

    public void setDrawW(int drawW) {
        this.drawW = drawW;
    }

    public int getDrawH() {
        return drawH;
    }

    public void setDrawH(int drawH) {
        this.drawH = drawH;
    }


    // définit la coordonnée X de la balle
    public void setX(double x) {
        this.x = x;
    }

    // définit la coordonnée Y de la balle
    public void setY(double y) {
        this.y = y;
    }

    // retourne la coordonnée X de la balle
    public double getX() {
        return x;
    }

    // retourne la coordonnée Y de la balle
    public double getY() {
        return y;
    }
}
