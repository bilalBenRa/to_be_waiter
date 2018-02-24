package ben.to_be_waiter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by bilel on 19/07/2017.
 */

public class Draw {
    protected BitmapDrawable img=null; // image de la balle
    protected double x,y; // coordonnées x,y de la balle en pixel
    protected int drawW, drawH; // largeur et hauteur de la balle en pixels
    protected int wEcran,hEcran; // largeur et hauteur de l'écran en pixels
    protected int ressource;

    protected  final Context mContext;

    public Draw(final Context c,double x ,double y,int w , int h,int ressource)
    {
        this.x = x; this.y = y;
        // position de départ
        this.drawW=w;this.drawH=h;
        mContext=c; // sauvegarde du contexte
        this.ressource=ressource;
        Drawable dr = c.getResources().getDrawable(this.ressource);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        img= new BitmapDrawable(c.getResources(), Bitmap.createScaledBitmap(bitmap, drawW, drawH, true));

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

    protected void  changeImg(int ressource){
        this.ressource=ressource;
        Drawable dr = mContext.getResources().getDrawable(this.ressource);
        Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
        img= new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(bitmap, drawW, drawH, true));
    }

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

    // on dessine l'image, en x et y
    protected void draw(Canvas canvas)
    {

        if(img==null) {return;}
        canvas.drawBitmap(img.getBitmap(),(int) x,(int) y, null);
    }
}
