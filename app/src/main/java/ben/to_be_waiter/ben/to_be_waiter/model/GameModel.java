package ben.to_be_waiter.ben.to_be_waiter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BBABE69 on 25/02/2018.
 */

public class GameModel {
    private Player player;
    private List<Food> foods;

    public GameModel(double x,double y) {
        this.player = new Player(x,y);
        this.foods=new ArrayList<>();

    }

    public void loadFood(double x, double y){
        this.foods.add(new TestFood(new Position(x,y)));

    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Player getPlayer() {
        return player;
    }


}
