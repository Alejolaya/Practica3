package com.example.alejolaya.punto4;

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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RadioButton btn1 = (RadioButton) findViewById(R.id.rbcuad);
        final RadioButton btn2 = (RadioButton) findViewById(R.id.rbtria);
        final RadioButton btn3 = (RadioButton) findViewById(R.id.rbrect);
        final RadioButton btn4 = (RadioButton) findViewById(R.id.rbcirc);
        final EditText etL = (EditText) findViewById(R.id.etLado);
        final EditText etB = (EditText) findViewById(R.id.etBase);
        final EditText etA = (EditText) findViewById(R.id.etAltura);
        final EditText etR = (EditText) findViewById(R.id.etRadio);
        Button calcular = (Button) findViewById(R.id.bCalcular);
        final TextView Resultado = (TextView) findViewById(R.id.tvResultado);
        final RadioGroup radioGrupo = (RadioGroup) findViewById(R.id.rgFigura);
//******************************************************************************************************************
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etL.setVisibility(View.VISIBLE);
                etA.setVisibility(View.INVISIBLE);
                etB.setVisibility(View.INVISIBLE);
                etR.setVisibility(View.INVISIBLE);
                etA.setText("");
                etB.setText("");
                etL.setText("");
                etR.setText("");

            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etL.setVisibility(View.INVISIBLE);
                etA.setVisibility(View.VISIBLE);
                etB.setVisibility(View.VISIBLE);
                etR.setVisibility(View.INVISIBLE);
                etA.setText("");
                etB.setText("");
                etL.setText("");
                etR.setText("");

            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etL.setVisibility(View.INVISIBLE);
                etA.setVisibility(View.VISIBLE);
                etB.setVisibility(View.VISIBLE);
                etR.setVisibility(View.INVISIBLE);
                etA.setText("");
                etB.setText("");
                etL.setText("");
                etR.setText("");

            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etL.setVisibility(View.INVISIBLE);
                etA.setVisibility(View.INVISIBLE);
                etB.setVisibility(View.INVISIBLE);
                etR.setVisibility(View.VISIBLE);
                etA.setText("");
                etB.setText("");
                etL.setText("");
                etR.setText("");

            }

        });
//******************************************************************************************************************
        calcular.setOnClickListener(new View.OnClickListener(){
          @Override
        public void onClick(View v) {

         double lado,base,altura,radio,Area=0;
              int selectedId = radioGrupo.getCheckedRadioButtonId();
              RadioButton figura = (RadioButton) findViewById(selectedId);
              String radioButtonSelected="";
              switch (selectedId) {
                  case R.id.rbcuad : radioButtonSelected = "rbcuad";
                      //resultado=numero1+numero2;

                      try{
                          lado = Double.parseDouble(etL.getText().toString());
                      }catch (Exception ex){
                          lado=0;
                      }
                      Area=lado*lado;
                      break;
                  case R.id.rbtria : radioButtonSelected = "rbtria";
                      //resultado=numero1-numero2;

                      try{
                          base=Double.parseDouble(etB.getText().toString());
                          }catch (Exception ex){
                          base=0;
                          }
                      try{
                          altura=Double.parseDouble(etA.getText().toString());
                      }catch (Exception ex){
                          altura=0;
                      }
                      Area=base*altura/2;
                      break;
                  case R.id.rbrect : radioButtonSelected = "rbrect";
                      //resultado=numero1*numero2;

                      try{
                          base=Double.parseDouble(etB.getText().toString());
                      }catch (Exception ex){
                          base=0;
                      }
                      try{
                          altura=Double.parseDouble(etA.getText().toString());
                      }catch (Exception ex){
                          altura=0;
                      }
                      Area=base*altura;
                      break;
                  case R.id.rbcirc : radioButtonSelected = "rbcirc";
                      //resultado=numero1/numero2;

                      try{
                          radio=Double.parseDouble(etR.getText().toString());
                      }catch (Exception ex){
                          radio=0;
                      }
                      Area=2*3.1416*radio*radio;
                      break;
                  default:
                      Area=0;
                      break;
              }
            Resultado.setText(String.valueOf(Area));

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
