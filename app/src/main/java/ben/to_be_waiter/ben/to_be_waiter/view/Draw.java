package ben.to_be_waiter.ben.to_be_waiter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import ben.to_be_waiter.ben.to_be_waiter.model.Position;

/**
 * Created by bilel on 19/07/2017.
 */

public abstract class Draw {

    BitmapDrawable imageBitmapDrawable;
    protected Position position; // coordonnées x,y de
    protected double drawWidth;
    protected double drawHeight; // largeur et hauteur
    protected int ressource;

    protected  final Context mContext;

    public Draw(final Context c,double x ,double y,int w , int h,int ressource)
    {
        this.position=new Position(x,y);
        // position de départ
        this.drawWidth =w;
        this.drawHeight =h;
        mContext=c; // sauvegarde du contexte
        this.ressource=ressource;
        Drawable dr = c.getResources().getDrawable(this.ressource);
        imageBitmapDrawable = new BitmapDrawable(mContext.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) dr).getBitmap(), (int) drawWidth,(int) drawHeight, true));
    }


    // on dessine l'image, en x et y
    protected void draw(Canvas canvas)
    {
        if(imageBitmapDrawable ==null) {return;}

       canvas.drawBitmap(imageBitmapDrawable.getBitmap(),(float) this.position.getX(),(float) this.position.getY(), null);

    }


    abstract  void draw();



    // définit la coordonnée X de la balle
    public void setX(double x) {
        this.position.setX(x);
    }

    // définit la coordonnée Y de la balle
    public void setY(double y) {
        this.position.setY(y);;
    }

    // retourne la coordonnée X de la balle

    public double getDrawWidth() {
        return drawWidth;
    }

    public void setDrawWidth(double drawWidth) {
        this.drawWidth = drawWidth;
    }

    public double getDrawHeight() {
        return drawHeight;
    }

    public void setDrawHeight(double drawHeight) {
        this.drawHeight = drawHeight;
    }

    public double getX() {
        return position.getX();
    }

    // retourne la coordonnée Y de la balle
    public double getY() {
        return this.position.getY();
    }
}
