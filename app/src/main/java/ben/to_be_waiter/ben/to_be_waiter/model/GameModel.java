package ben.to_be_waiter.ben.to_be_waiter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BBABE69 on 25/02/2018.
 */

public class GameModel {
    private ElementGame player;
    private ElementGame plateau;
    private List<ElementGame> foods;



    public GameModel() {
        this.foods=new ArrayList<>();
    }

    public void loadPlayer(double x,double y){
        this.player = new Player(x,y);
    }
    public void loadPlateau(double x,double y,double xBeta,double yBeta){
        this.plateau= new Plateau(x,y,xBeta,yBeta);
    }

    public void loadFood(double x, double y){
        this.foods.add(new TestFood(x,y));
    }

    public List<ElementGame> getFoods() {
        return foods;
    }

    public void setFoods(List<ElementGame> foods) {
        this.foods = foods;
    }

    public void setPlayer(ElementGame player) {
        this.player = player;
    }

    public ElementGame getPlateau() {
        return plateau;
    }

    public void setPlateau(ElementGame plateau) {
        this.plateau = plateau;
    }

    public ElementGame getPlayer() {
        return player;
    }

    public boolean collisionPlateauToFoods(int i){
        double xFood=foods.get(i).getX();
        double yFood=foods.get(i).getY();
        System.out.println("xfood"+xFood);
        System.out.println("xBeta"+plateau.getXBeta());
        System.out.println("xPlateau"+plateau.getX());

       if(xFood>=plateau.getX() && xFood<=plateau.getXBeta() ){
           return  true;
       }else {
           return false;
       }
    }






}
