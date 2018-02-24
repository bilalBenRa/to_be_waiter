package ben.to_be_waiter.ben.to_be_waiter.view;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On cré un objet "GameView" qui est le code principal du jeu
        gameView=new GameView(this);

        // et on l'affiche.
        setContentView(gameView);
    }

} // class MainActivity