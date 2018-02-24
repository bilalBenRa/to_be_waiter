package ben.to_be_waiter.ben.to_be_waiter.model;

/**
 * Created by BBABE69 on 25/02/2018.
 */

public class GameModel {
    private Player player;

    public GameModel(double x,double y) {
        this.player = new Player(x,y);
    }
}
