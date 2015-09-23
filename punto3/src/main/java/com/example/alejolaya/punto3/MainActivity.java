package com.example.alejolaya.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText quices = (EditText) findViewById(R.id.etQuices);
        final EditText expo = (EditText) findViewById(R.id.etExpo);
        final EditText lab = (EditText) findViewById(R.id.etLab);
        final EditText Profinal = (EditText) findViewById(R.id.etProFinal);
        Button calcular = (Button) findViewById(R.id.bCalcular);
        final TextView Resultado = (TextView) findViewById(R.id.tvResultado);


        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name;
                //name = Nombre.getText().toString();
                double q,exp,l,p;
                try {
                    q = Double.parseDouble(quices.getText().toString());
                } catch (Exception ex) {
                    q = 0;
                }
                try {
                    exp = Double.parseDouble(expo.getText().toString());
                } catch (Exception ex) {
                    exp = 0;
                }
                try {
                    l = Double.parseDouble(lab.getText().toString());
                } catch (Exception ex) {
                    l = 0;
                }
                try {

                    p = Double.parseDouble(Profinal.getText().toString());
                } catch (Exception ex) {

                    p = 0;
                }
                if((q>=0 && q<=5)&&(exp>=0 && exp<=5)&&(l>=0 && l<=5)&&(p>=0 && p<=5)) {
                    Resultado.setText(String.valueOf(q * 0.15 + exp * 0.1 + l * 0.4 + p * 0.35));
                }
                else Resultado.setText("Error");

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
