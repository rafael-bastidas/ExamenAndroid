package com.myrdigitalcoaches.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    LayoutInflater layoutInflater;
    View popupView;
    PopupWindow popupWindow;

    Button btn_Cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button salir = findViewById(R.id.button_salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        Button reservar = findViewById(R.id.button_reservar);
        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                popupView = layoutInflater.inflate(R.layout.popup, null);
                popupWindow = new PopupWindow(popupView, RadioGroup.LayoutParams.WRAP_CONTENT,
                        RadioGroup.LayoutParams.WRAP_CONTENT);

                btn_Cerrar = (Button)popupView.findViewById(R.id.id_cerrar);
                btn_Cerrar.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }});

                //popupWindow.showAsDropDown(reservar, Gravity.CENTER);
                popupWindow.showAtLocation(reservar, Gravity.CENTER,0,0);
            }
        });
    }
}