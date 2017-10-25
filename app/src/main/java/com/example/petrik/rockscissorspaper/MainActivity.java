package com.example.petrik.rockscissorspaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_ko, btn_papir, btn_ollo;
    private TextView eredmeny;
    private ImageView ember,robot;
    private int ember_pont = 0, robot_pont = 0;
    private String evalaszt, rvalaszt, result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ko = (Button) findViewById(R.id.button_rock);
        btn_ollo = (Button) findViewById(R.id.button_scissors);
        btn_papir = (Button) findViewById(R.id.button_paper);

        eredmeny = (TextView) findViewById(R.id.textView_score);

        ember = (ImageView) findViewById(R.id.imageView_human);
        robot = (ImageView) findViewById(R.id.imageView_robot);

        r = new Random();

        btn_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember.setImageResource(R.drawable.rock);
                evalaszt = "Kő";
                calc();
            }
        });

        btn_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember.setImageResource(R.drawable.paper);
                evalaszt = "Papír";
                calc();
            }
        });

        btn_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ember.setImageResource(R.drawable.scissors);
                evalaszt = "Olló";
                calc();
            }
        });
    }
    public void calc(){
        int com = r.nextInt(3);
        if (com == 0){
            rvalaszt = "Kő";
            robot.setImageResource(R.drawable.rock);
        } else if (com == 1){
            rvalaszt = "Papír";
            robot.setImageResource(R.drawable.paper);
        } else if (com == 2){
            rvalaszt = "Olló";
            robot.setImageResource(R.drawable.scissors);
        }

        if (evalaszt.equals("Kő") && rvalaszt.equals("Papír")){
            result = "Papír erősebb, mint a kő. Vesztettél!";
            robot_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Kő") && rvalaszt.equals("Olló")){
            result = "Kő erősebb, mint az olló. Nyertél!";
            ember_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Papír") && rvalaszt.equals("Kő")){
            result = "Papír erősebb, mint a kő. Nyertél!";
            ember_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Papír") && rvalaszt.equals("Olló")){
            result = "Olló erősebb, mint a papír. Vesztettél!";
            robot_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Olló") && rvalaszt.equals("Papír")){
            result = "Olló erősebb, mint a papír. Nyertél!";
            ember_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Olló") && rvalaszt.equals("Kő")){
            result = "Kő erősebb, mint az olló. Vesztettél!";
            robot_pont++;
            eredmeny.setText("Eredmény: Ember: " + ember_pont + " Computer: " + robot_pont);
        }
        if (evalaszt.equals("Olló") && rvalaszt.equals("Olló")){
            result = "Döntetlen. Senki nem nyert.";
        }
        if (evalaszt.equals("Kő") && rvalaszt.equals("Kő")){
            result = "Döntetlen. Senki nem nyert.";
        }
        if (evalaszt.equals("Papír") && rvalaszt.equals("Papír")){
            result = "Döntetlen. Senki nem nyert.";
        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }


}
