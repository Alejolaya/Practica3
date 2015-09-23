package com.example.alejolaya.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.alejolaya.punto2.R.id.tresultado;
import static com.example.alejolaya.punto2.R.id.rbsuma;
import static com.example.alejolaya.punto2.R.id.rgOperacion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText valor1 = (EditText) findViewById(R.id.etvalor1);
        final EditText valor2 = (EditText) findViewById(R.id.etvalor2);
        final RadioGroup radioGrupo = (RadioGroup) findViewById(rgOperacion);

        Button operar = (Button) findViewById(R.id.boperar);
        final TextView tResultado = (TextView) findViewById(R.id.tresultado);

        operar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name;
                //name = Nombre.getText().toString();
                double numero1;
                double numero2;
                double resultado=0;
                numero1 = Double.parseDouble(valor1.getText().toString());
                numero2 = Double.parseDouble(valor2.getText().toString());

                // get selected radio button from radioGroup
                   int selectedId = radioGrupo.getCheckedRadioButtonId();

                // find the radiobutton by returned id
               RadioButton rboperador = (RadioButton) findViewById(selectedId);

                String radioButtonSelected = "";

                switch (selectedId) {
                    case R.id.rbsuma : radioButtonSelected = "rbsuma";
                        resultado=numero1+numero2;
                        break;
                    case R.id.rbresta : radioButtonSelected = "rbresta";
                        resultado=numero1-numero2;
                        break;
                    case R.id.rbmult : radioButtonSelected = "rbmult";
                        resultado=numero1*numero2;
                        break;
                    case R.id.rbdiv : radioButtonSelected = "rbdiv";
                        resultado=numero1/numero2;
                        break;
                    default:
                        resultado=0;
                        break;
                }

                tResultado.setText(String.valueOf(resultado));
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
