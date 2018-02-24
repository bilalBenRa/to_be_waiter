package ben.to_be_waiter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends Activity {
    private Button bouton;
    private TextView tv;
    private Toast test;
    private LinearLayout groupeDeVue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Toast.makeText(this, "huhu", 10);
        tv = new TextView(this);
        bouton = new Button(this);
        bouton.setMinimumWidth(100);
        groupeDeVue = new LinearLayout(this);
        groupeDeVue.addView(bouton);
        groupeDeVue.addView(tv);
        groupeDeVue.setOrientation(1);
        setContentView(groupeDeVue);
        bouton.setText("Play game");

        bouton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
