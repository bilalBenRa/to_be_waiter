package ben.to_be_waiter;

/**
 * Created by bilel on 14/07/2017.
 */
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class Sprite {
    private static final int BMP_ROWS =3;
    private static final int BMP_COLUMNS =5;
    private int x = 0;
    private int y = 0;
    int nb=0;
    private int xSpeed = 5;
    private GameView gameView;
    private BitmapDrawable bmp;
    private int currentFrame = 0;
    private int width;
    private int height;

    public Sprite(GameView gameView, BitmapDrawable bmp) {
        this.gameView = gameView;
        this.bmp = bmp;
        this.width = 288;
        this.height = 388;
    }

    private void update() {
        if (x > gameView.getWidth() - width - xSpeed) {
            xSpeed = -5;
        }
        if (x + xSpeed < 0) {
            xSpeed = 5;
        }
        x = x + 5;
        nb=(currentFrame/6)%BMP_COLUMNS;
        currentFrame++;
    }

    public void onDraw(Canvas canvas) {
        update();
        int srcX = nb* width;
        int srcY = 1;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        canvas.drawBitmap(bmp.getBitmap(), src, dst, null);
    }

}
