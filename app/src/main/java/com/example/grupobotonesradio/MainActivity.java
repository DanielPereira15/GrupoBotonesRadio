package com.example.grupobotonesradio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnAnadir;
    RadioGroup rgColor;
    RadioGroup rgUbicacion;
    LinearLayout llIzquierda;
    LinearLayout llDerecha;
    Button btreset;
    int contIz=0;
    int contDe=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAnadir=findViewById(R.id.btAnadir);
        rgColor=findViewById(R.id.rgColor);
        rgUbicacion=findViewById(R.id.rgUbicacion);
        llIzquierda=findViewById(R.id.llIzquierda);
        llDerecha=findViewById(R.id.llDerecha);
        btreset=findViewById(R.id.btReset);

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tvAnadida= new TextView(MainActivity.this);
                switch (rgColor.getCheckedRadioButtonId()){
                    case R.id.rbRojo:
                        tvAnadida.setBackgroundColor(Color.RED);

                        break;

                    case R.id.rbVerde:
                        tvAnadida.setBackgroundColor(Color.GREEN);

                        break;

                    case R.id.rbAzul:
                        tvAnadida.setBackgroundColor(Color.BLUE);
                        break;

                }
                if(rgUbicacion.getCheckedRadioButtonId()==R.id.rbIzquierda){
                    tvAnadida.setText(""+contIz);
                    tvAnadida.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tvAnadida.setTextSize(20);
                    llIzquierda.addView(tvAnadida);
                    contIz++;
                }else{
                    tvAnadida.setText(""+contDe);
                    tvAnadida.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    tvAnadida.setTextSize(20);
                    llDerecha.addView(tvAnadida);
                    contDe++;
                }
            }
        });


        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                para borrar las vistas seria
                llizquierda.removeAllViews();
                 */

                TextView tv;
                for(int i=0;i<llIzquierda.getChildCount();i++){
                    if(llIzquierda.getChildAt(i) instanceof TextView){
                        tv=(TextView) llIzquierda.getChildAt(i);
                        tv.setText("X");
                        contIz=0;
                        }
                    }
                TextView tv2;
                for(int i=0;i<llDerecha.getChildCount();i++){
                    if(llDerecha.getChildAt(i) instanceof TextView){
                        tv2=(TextView) llDerecha.getChildAt(i);
                        tv2.setText("X");
                        contDe=0;
                    }
                }
                }
        });

    }
}