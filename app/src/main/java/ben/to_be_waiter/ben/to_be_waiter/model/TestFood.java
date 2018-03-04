package ben.to_be_waiter.ben.to_be_waiter.model;

/**
 * Created by BBABE69 on 2/03/2018.
 */

public class TestFood extends Food {

    private double acceleration;

    public TestFood(double x, double y, double xBeta, double yBeta) {
        super(x, y, xBeta, yBeta);
        this.acceleration=1;
    }

    public TestFood(double x, double y) {
        super(x, y);
        this.acceleration=1;
    }


    @Override
    public void move() {
        this.acceleration=acceleration+0.5;
        this.setY(this.getY()+this.acceleration);
    }


}
