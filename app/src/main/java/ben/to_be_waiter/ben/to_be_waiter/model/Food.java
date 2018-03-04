package ben.to_be_waiter.ben.to_be_waiter.model;

/**
 * Created by BBABE69 on 2/03/2018.
 */

public abstract class Food  extends ElementGame {


    public Food(double x, double y, double xBeta, double yBeta) {
        super(x, y, xBeta, yBeta);
    }

    public Food(double x, double y) {
        super(x, y);
    }

    @Override
    public abstract void move();
}
