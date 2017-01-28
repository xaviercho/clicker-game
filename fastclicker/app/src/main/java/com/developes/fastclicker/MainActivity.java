package com.developes.fastclicker;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageButton start, a, b,c2,d;
    TextView zero,tl,numc,countd;
    int c = 0;
    int flop = 0;
    int left = 30;
    boolean bruh = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rl;
        rl = (RelativeLayout) findViewById(R.id.activity_main);
       // rl.setBackground(getResources().getDrawable(R.drawable.blueb));

        start = (ImageButton) findViewById(R.id.imageButton5);
        a = (ImageButton) findViewById(R.id.imageButton4);
        b = (ImageButton) findViewById(R.id.imageButton3);

        final MediaPlayer mp9 = MediaPlayer.create(MainActivity.this,R.raw.pk);


        zero = (TextView) findViewById(R.id.zero);
        countd = (TextView) findViewById(R.id.countd);




     final    CountDownTimer timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                RelativeLayout rl;
                rl = (RelativeLayout) findViewById(R.id.activity_main);
                left--;
                flop++;
                countd.setText(Integer.toString(left));
                if(flop%3 ==0){

                //    rl.setTag(R.drawable.greeng);
                    rl.setBackground(getResources().getDrawable(R.drawable.greeng));
                    bruh =false;
                }else{
                  //  rl.setTag(R.drawable.blueb);
                    rl.setBackground(getResources().getDrawable(R.drawable.blueb));
                    bruh =true;
                }


            }

            @Override
            public void onFinish() {
                countd.setText(Integer.toString(0));
                a.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                start.setVisibility(View.VISIBLE);
            }
        };






        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp9.start();
                RelativeLayout rl;
                rl = (RelativeLayout) findViewById(R.id.activity_main);
                a.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);
                left =30;
                start.setVisibility(View.INVISIBLE);
                c = 0;
                zero.setText(Integer.toString(c));
                timer.start();

                rl.setBackground(getResources().getDrawable(R.drawable.blueb));
               // rl.setTag(R.drawable.blueb);

            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   // int resid = (Integer) v.getTag();
                    if(bruh == true){
                        c++;
                        zero.setText(Integer.toString(c));
                    }





            }
        });

       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(bruh == false){
                    c++;
                    zero.setText(Integer.toString(c));
                }

            }
        });




    }
}
